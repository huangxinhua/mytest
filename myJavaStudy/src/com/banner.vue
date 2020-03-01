<template>
  <div id="customMenu">
    <div class="customMenu">
      <div class="custom-menu-content">
        <LayoutPanel class="layout-panel"
                     title="设置">
          <div class="tree-one-box"
               ref="dragTreeBox"
               v-show="bannerData.length > 0">
            <div class="tree-one"
                 ref="dragTree">
              <Tree :data="bannerData"
                    ref="targetTree"
                    :space="6"
                    openedClass="tree-child"
                    :draggable="true"
                    :options="{handle:'icon_edit',animation:100}"
                    @drag="onDrag"
                    @drop="onDrop">
                <div slot-scope="{data}"
                     @click="editBanner(data)">
                  <el-popover trigger="click"
                              placement="right">
                    <!-- <el-table :data="bannerData">
                      <el-table-column width="150" property="text" label="text"></el-table-column>
                      <el-table-column width="100" property="icon_class" label="text"></el-table-column>
                      <el-table-column width="300" property="checked" label="地址"></el-table-column>
                    </el-table>-->
                    <form-panel layoutType="horizontal"
                                v-model="data"
                                ref="form">
                      <a-row type="flex"
                             align="left">
                        <a-col>
                          <text-input ref="input"
                                      name="text"
                                      label="菜单名称"
                                      tooltip="input1-tooltip"
                                      :required="false"
                                      placeholder="input"
                                      :avoidSpecialChars="true"
                                      :whenHiddenSkipCheck="true"></text-input>
                        </a-col>
                      </a-row>
                      <a-row>
                        <a-col :span="12">
                          <!-- <a-button text="确认" @click="handleClick(data)" :disabled="data.isEditAbble"></a-button> -->
                          <el-button type="text"
                                     @click="handleClick(data)"
                                     :disabled="data.isEditAbble">确认</el-button>
                        </a-col>
                      </a-row>
                    </form-panel>
                    <div slot="reference"
                         class="name-wrapper">
                      <div :class="['tree-content', {'tree-drop-not': !data.isDragPlaceHolder && dragging && !data.droppable}]">
                        <el-checkbox v-model="data.checked"></el-checkbox>
                        <span :class="data.icon_class"
                              style="margin-left:18px"></span>
                        <span :class="['label-content', 'label-padding']">{{getDisplayName(data)}}</span>
                        <span class="icon_ide_edit"></span>
                      </div>
                    </div>
                  </el-popover>
                </div>
              </Tree>
            </div>
          </div>
          <div class="exit">
            <el-checkbox></el-checkbox>
            <span class="icon_logout"
                  style="margin-left:18px"></span>
            <span style="margin-left: 15px;">退出登录</span>
          </div>
        </LayoutPanel>
      </div>
    </div>
  </div>
</template>

<script>
import _ from "lodash";
import { DraggableTree } from "vue-draggable-nested-tree";
import LayoutPanel from "./components/LayoutPanel";
import { Checkbox, Table, TableColumn, Button, Popover } from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import FormPanel from "@adc/adc-ui/lib/form-panel";
import ACol from "@adc/adc-ui/lib/col";
import ARow from "@adc/adc-ui/lib/row";
import TextInput from "@adc/adc-ui/lib/text-input";
import AButton from "@adc/adc-ui/lib/button";
import Vue from "vue";
Vue.use(Button);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Popover);
export default {
  name: "banner",
  components: {
    LayoutPanel,
    Tree: DraggableTree,
    Checkbox,
    FormPanel,
    ACol,
    ARow,
    TextInput,
    AButton
  },
  data () {
    return {
      popoverVisible: false,
      isShowRuler: true,
      isShowConfirmDialog: false,
      isShowInfo: false,
      dragging: false,
      maxTreeLevel: 1,
      showNodeEdit: false,
      bannerData: [
        {
          text: "个人设置",
          sort: "1",
          icon_class: "icon_copy",
          checked: "true",
          isEditAbble: true
        },
        {
          text: "切换租户",
          sort: "2",
          icon_class: "icon_copy",
          checked: "true",
          isEditAbble: true
        },
        {
          text: "语言切换",
          sort: "3",
          icon_class: "icon_copy",
          checked: "true",
          isEditAbble: false
        }
      ]
    };
  },
  computed: {},
  mounted () {
    // this.init();
  },
  created () {
    document.title = this.$t("title");
  },
  methods: {
    //拖拽操作
    onDrag (node) {
      this.dragging = true;
      // 根据拖拽位置更新动画
      this.checkScrollBarr(node);
      // 控制菜单级数
      let nodeLevels = 1;
      this.depthFirstSearch(node, childNode => {
        if (childNode._vm.level > nodeLevels) {
          nodeLevels = childNode._vm.level;
        }
      });
      nodeLevels = nodeLevels - node._vm.level + 1;
      const childNodeMaxLevel = this.maxTreeLevel - nodeLevels;
      this.depthFirstSearch(this.bannerData, childNode => {
        if (childNode !== node) {
          const droppable =
            !childNode.page &&
            childNode._vm &&
            childNode._vm.level <= childNodeMaxLevel;
          this.$set(childNode, "droppable", droppable);
        }
      });
    },
    depthFirstSearch (obj, handler, childrenKey = "children", reverse) {
      const rootChildren = Array.isArray(obj) ? obj : [obj];
      const StopException = () => { };
      const func = (children, parent) => {
        if (reverse) {
          children = children.slice();
          children.reverse();
        }
        const len = children.length;
        for (let i = 0; i < len; i++) {
          const item = children[i];
          const r = handler(item, i, parent);
          if (r === false) {
            // stop
            throw new StopException();
          } else if (r === "skip children") {
            continue;
          } else if (r === "skip siblings") {
            break;
          }
          if (item[childrenKey] != null) {
            func(item[childrenKey], item);
          }
        }
      };
      try {
        func(rootChildren);
      } catch (e) {
        if (e instanceof StopException) {
          // stop
        } else {
          throw e;
        }
      }
    },
    onDrop () {
      this.dragging = false;
    },
    //拖拽时动画更新滚动条
    checkScrollBarr () {
      const critical = 88;
      const root = this.$refs["dragTree"];
      const rootHeight = root.offsetHeight;
      function check () {
        const ele = document.getElementsByClassName("dragging")[0];
        if (!ele) return;
        const offset = ele.offsetTop;
        const distanceBottom = rootHeight - offset;
        const distanceTop = offset;
        if (distanceBottom < critical) {
          root.scrollTop += 5;
        } else if (distanceTop < critical) {
          root.scrollTop -= 5;
        }
        if (this.dragging) {
          requestAnimationFrame(check.bind(this));
        }
      }
      //浏览器在下次重绘之前调用指定的回调函数更新动画
      requestAnimationFrame(check.bind(this));
    },
    // 将树形结构产生的多余数据删除
    getTreePureData (node) {
      const t = Object.assign({}, node);
      delete t._id;
      delete t.parent;
      delete t.children;
      delete t.active;
      delete t.style;
      delete t.class;
      delete t.innerStyle;
      delete t.innerClass;
      delete t.innerBackStyle;
      delete t.innerBackClass;
      for (const key of Object.keys(t)) {
        if (key[0] === "_") {
          delete t[key];
        }
      }
      if (node.children) {
        t.children = node.children.slice();
        t.children.forEach((v, k) => {
          t.children[k] = this.getTreePureData(v);
        });
      }
      return t;
    },
    editBanner (row) {
      console.log("edit:", row);
      this.popoverVisible = true;
      console.log("edit:", this.popoverVisible);
    },
    handleClick (data) {
      console.log("formclick", data);
      this.popoverVisible = false;
    },
    //拖拽后树形结构发生变化，重新生成新数据
    // onTreeChange(node, targetTree) {
    //     this.$nextTick(() =>
    //         this.$store.commit(
    //             "deepTreeToTargetNode",
    //             this.getTreePureData(targetTree.rootData).children
    //         )
    //     );
    //     this.$nextTick(() =>
    //         this.$store.commit(
    //             "deepTreeToOriginalNode",
    //             this.getTreePureData(targetTree.rootData).children
    //         )
    //     );
    // },
    // onOriginalNodeOpenChange(node) {
    //     this.$store.commit("setOriginalNodeOpenStatus", {
    //         keyCode: node.keycode,
    //         open: node.open
    //     });
    // },

    getDisplayName (data) {
      return data.text;
    }
  }
};
</script>

<style lang="less">
html,
body {
  height: 100%;
}
#customMenu {
  padding: 20px;
  box-sizing: border-box;
  height: 100%;
  * {
    box-sizing: border-box;
  }
  .menueName {
    margin-top: 10px;
  }
  .exit {
    margin: 0px 17px 17px 17px;
    border-top: 1px solid #e6eaf2;
    padding-top: 17px;
  }
  .customMenu {
    max-width: 1200px;
    margin: 0 auto;
    background: #fff;
    border-radius: 5px;
    box-sizing: border-box;
    border: 1px solid #e6eaf2;
    padding: 25px 40px;
  }
  .custom-menu-content {
    display: flex;
    align-items: center;
    margin-top: 10px;
    height: calc(100% - 120px);
    width: 320px;
  }
  .custom-menu-select {
    width: 36px;
    height: 24px;
    line-height: 24px;
    border-radius: 2px;
    border: 1px solid #2b86ff;
    text-align: center;
    color: #2b86ff;
    font-size: 20px;
    margin: 0 20px;
    cursor: pointer;
  }
  .tree-one-box {
    position: relative;
    height: 100%;
    overflow: hidden;
    user-select: none;
    .node-edit-mask {
      position: absolute;
      top: 0;
      bottom: 0;
      left: 0;
      right: 0;
      background-color: rgba(0, 0, 0, 0.5);
    }
    .edit-box {
      position: absolute;
      width: 300px;
      left: 50%;
      transform: translateX(-50%);
    }
  }
  .layout-panel {
    width: 500px;
  }
  .tree-one {
    padding: 10px;
    font-size: 14px;
    line-height: 2;
    color: #242a34;
    overflow-y: auto;
    overflow-x: hidden;
    height: 100%;
    box-sizing: border-box;
    .tree-node-children {
      overflow-x: hidden;
    }
    .icon-open {
      font-size: 20px;
      color: #94a0b6;
      margin-left: -5px;
    }
    .label-content {
      display: inline-block;
      max-width: calc(100% - 60px);
      text-overflow: ellipsis;
      overflow: hidden;
      white-space: nowrap;
    }
    .tree-content {
      @nodeH: 32px;
      padding: 0 8px;
      cursor: pointer;
      line-height: 32px;
      .label-padding {
        padding-left: 15px;
      }
      &.tree-drop-not {
        background: #f5f5f5;
        color: #94a0b6;
        cursor: not-allowed;
      }
      .icon_ide_add {
        display: none;
        font-size: 16px;
        color: #96a2bb;
        cursor: pointer;
        float: right;
        line-height: @nodeH;
        margin-right: 6px;
      }
      .icon_close {
        font-size: 20px;
        color: #96a2bb;
        cursor: pointer;
        float: right;
        line-height: @nodeH;
      }
      .icon_ide_edit {
        font-size: 16px;
        color: #96a2bb;
        cursor: pointer;
        float: right;
        line-height: @nodeH;
      }
      &:hover {
        .icon_ide_add {
          display: block;
        }
        .tree-active;
      }
    }
    .tree-active {
      background: #eff6ff;
      // color: #db061f;
      font-weight: 500;
      // span {
      //     color: #db061f;
      // }
    }
    .tree-hover {
      cursor: pointer;
      &:hover {
        .tree-active;
      }
    }
    .tree-lock {
      background: #f5f5f5;
      color: #94a0b6;
      padding-left: 5px;
      cursor: not-allowed;
      span {
        color: #94a0b6;
      }
      .span-edit {
        color: #2c86ff;
      }
    }
    span {
      vertical-align: middle;
    }
    .tree-padding {
      padding-left: 15px;
      line-height: 32px;
    }
    .tree-child {
      > .tree-node-children {
        padding-left: 16px;
      }
    }
  }
  .no-select-view {
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 14px;
    color: #94a0b6;
  }

  .custom-menu-foot {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 20px;

    .btn {
      border-radius: 2px;
      padding: 6px 20px;
      text-align: center;
      font-size: 14px;
      box-sizing: border-box;
      cursor: pointer;
    }
    .btn-primary {
      background: #2c86ff;
      color: #ffffff;
    }
    .btn-default {
      background: #fff;
      color: #2c86ff;
      border: 1px solid #2c86ff;
      margin-left: 20px;
    }
  }

  .draggable-placeholder {
    margin: 8px 0;
  }

  .draggable-placeholder-inner {
    border-bottom: 1px solid #db061f;
    box-sizing: border-box;
    background: rgba(0, 136, 249, 0.09);
    padding: 8px;
    margin: 6px;
    .tree-content {
      display: none;
    }
  }
}
</style>
<i18n>
  {
    "en": {
      "title": "Customized Menu",
      "customMenu": {
        "noCustomMenu": "The 'Customized Menu' must be added to the new menu list, otherwise the menu will not be edited later!",
		"CustomMenuForbidParent": "The 'Customized Menu' must be leaf menu, can not have child!",
        "menuListTitle": "Menu List",
        "selectedMenuTitle": "Selected Menu",
        "selectedPanelTips": "Add a menu from the menu list on the left",
        "saveBtn": "Save",
        "cancelBtn": "Cancel",
        "saveSuccess": "Save successfully!",
        "saveFail": "Save failed!"
      }
    },
    "zh_CN": {
      "title": "菜单管理",
      "customMenu": {
        "noCustomMenu": "必须添加'租户自定义菜单'到新的菜单列表中，否则后续将无法编辑菜单！",
		"CustomMenuForbidParent": "'租户自定义菜单' 必须是叶子菜单，不能有子菜单!",
        "menuListTitle": "菜单列表",
        "selectedMenuTitle": "已选菜单",
        "selectedPanelTips": "从左侧菜单列表添加菜单",
        "saveBtn": "保存",
        "cancelBtn": "取消",
        "saveSuccess": "保存成功",
        "saveFail": "保存失败"
      }
    }
  }
</i18n>
