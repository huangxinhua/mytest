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
