# mytest
这是我的测试目录，用于学习
目前还没有整理
# 功能1
1.
2.
 List uniqueList = groupIds.stream().distinct().collect(Collectors.toList());
        // 分组后的list
        List<List<String>> groupedIdList= Lists.partition(uniqueList,10 );
        List<CompletableFuture<ResultBody<List<TyGroupVo>>>> futureList=groupedIdList.
            stream().map(
                v->CompletableFuture.supplyAsync(()->{
                    ApplicationContextHelper.setApplicationContextUser();
                    return queryTyGroupList(v);
                },
                ThreadPoolFactory.executor)).collect(Collectors.toList());
        // 确保所有的任务完成
        List<ResultBody<List<TyGroupVo>>> resultBeanList =
            futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        Map<String, TyGroupVo> groupVoMap = new HashMap<>();

  =VLOOKUP(I2,'D:\CITC\40_版本开发\202404版\[维成员映射-生产-ALL.xlsx]维成员映射行信息'!$I:$I,1,0)

  purge recyclebin 清空回收站对象
jps  查询java进程号
jinfo -flags  XX（进程号） 查看启动的参数
jstat -gc XX(进程号) 1000 10 每1000毫秒查询gc情况，10次
JVM NewRatio与SurvivorRatio: https://sulangsss.github.io/2019/04/08/Java/JVM/Optimize/NewRatio%E4%B8%8ESurvivorRatio/

https://pdai.tech/md/java/jvm/java-jvm-gc.html
