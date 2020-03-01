<template>
  <div class="layout-panel">
    <div class="layout-panel-head">
      {{title}}
      <template v-if="subTitle || subTitle === 0">
        &nbsp;(<span>{{subTitle}}</span>)
      </template>
    </div>
    <div class="layout-panel-body"><slot></slot></div>
  </div>
</template>

<script>
export default {
  name: 'layout-panel',
  props: {
    title: {
      type: String,
      require: true,
      default: ''
    },
    subTitle: {
      type: Number,
      require: false
    }
  }
}
</script>

<style type="text/less" lang="less" scoped>
.layout-panel {
  flex: 1;
  border: 1px solid #e6eaf2;
  border-radius: 2px;
  height: 100%;

  .layout-panel-head {
    padding: 0 24px;
    border-bottom: 1px solid #e6eaf2;
    font-size: 16px;
    line-height: 40px;
    color: #78849c;
    span {
      color: #3389fb;
    }
  }
  .layout-panel-body {
    height: calc(100% - 40px);
    overflow-y: auto;
  }
}
</style>
