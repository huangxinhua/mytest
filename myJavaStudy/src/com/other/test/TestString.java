package com.other.test;

class One {
	One(String str) {
		System.out.println(str);
	}
// 	 List uniqueList = groupIds.stream().distinct().collect(Collectors.toList());
//         // 分组后的list
//         List<List<String>> groupedIdList= Lists.partition(uniqueList,10 );
//         List<CompletableFuture<ResultBody<List<TyGroupVo>>>> futureList=groupedIdList.
//             stream().map(
//                 v->CompletableFuture.supplyAsync(()->{
//                     ApplicationContextHelper.setApplicationContextUser();
//                     return queryTyGroupList(v);
//                 },
//                 ThreadPoolFactory.executor)).collect(Collectors.toList());
//         // 确保所有的任务完成
//         List<ResultBody<List<TyGroupVo>>> resultBeanList =
//             futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
//         Map<String, TyGroupVo> groupVoMap = new HashMap<>();
}

//git hub多个仓库
// [core]
// 	repositoryformatversion = 0
// 	filemode = false
// 	bare = false
// 	logallrefupdates = true
// 	symlinks = false
// 	ignorecase = true
// [remote "origin"]
// 	url = https://***/hWX947526/CadWorkFlowService.git
// 	fetch = +refs/heads/*:refs/remotes/origin/*
// [remote "retmote_br"]
// 	url = https://**/CBGIT-IPD/CMDA/CadWorkFlowService.git
// 	fetch = +refs/heads/*:refs/remotes/retmote_br/*
// [branch "master"]
// 	remote = origin
// 	merge = refs/heads/master
// [branch "dev"]
// 	remote = origin
// 	merge = refs/heads/Br_develop





// 1.排序，带参数类型
list.sort((String s1, String s2) -> s1.compareTo(s2));
list.sort(( LibraryDO lib1, LibraryDO lib2) -> lib2.getId().compareTo(lib2.getId()));
// 使用默认方法排序
Collections.sort(list, Comparator.comparing(LibraryDO::getId)); //升序
Collections.reverse(list); // 倒序排列
//随机打乱顺序
Collections.shuffle(list);
//更多排序
//默认ASC排序）
List<LibraryDO> collect = users.stream().sorted(Comparator.comparing(LibraryDO::getId)).collect(Collectors.toList());
//DESC排序）
List<LibraryDO> collect = users.stream().sorted(Comparator.comparing(LibraryDO::getId).reversed()).collect(Collectors.toList());

// 2.数组去重
List<String> collect = list.stream().distinct().collect(Collectors.toList());
// 数组去重转换为字符串
String joining = list.stream().distinct().collect(Collectors.joining(",")); 
// 根据对象属性去重
List<LibraryDO> lib = list.stream().collect(Collectors.collectingAndThen(
					Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(LibraryDO::getId))), ArrayList<LibraryDO>::new));

// 4.获取对象某一属性返回list
List<String> collect= list.stream().map(LibraryDO::getId).collect(Collectors.toList());
// 获取对象某一属性返回数组
Integer[] array = list.stream().map(LibraryDO::getId).collect(Collectors.toList()).stream().toArray(Integer[]::new);
// 获取对象某一属性返回数组过滤非空
Integer[] array = list.stream().map(LibraryDO::getId).filter(x -> x !=null).collect(Collectors.toList()).stream().toArray(Integer[]::new);
//5.修改对象属性值
List<LibraryDO> lib = list.stream().map(p -> {p.setId(p.getId() + 1);return p;}).collect(Collectors.toList())


Map<String, List<String>> locationMap = locations.stream()
        .map(s -> s.split(":"))
        .collect(Collectors.groupingBy(a -> a[0],
                Collectors.mapping(a -> a[1], Collectors.toList())));
Map<String,List<ProblemInstanceExtendVo>>problemsByDomain=problemList.stream().collect(Collectors.groupingBy(ProblemInstanceExtendVo::getProblemDomain));


List<CompletableFuture<DocumentVO>>futureList=docList.stream()
.map(v->CompletableFuture.supplyAsync(()->iDocumentThreadTaskService.queryDocDetails(v),ThreadPoolFactory.executor))
.collect(Collectors.toList());

//CompletableFuture<List<DocumentVO>>docListFuture=CompletableFuture.supplyAsync(()->
//{
//ApplicationContextHelper.setApplicationContextUser();
//returngetDocList(paramVO,userVO);
//}
//,ThreadPoolFactory.executor);

//分组后的list
List<List<String>>groupedIdList=Lists.partition(uniqueList,10);

Map<String, String> instanceMap = baseInfo.stream().collect(Collectors.toMap(ComponentVo::getCode, ComponentVo::getValue));
 
objInstanceService.removeByIds(instanceSonList.stream().map(ObjInstance::getId).collect(Collectors.toList()));

List<String> queryParams = list.stream().map(CheckListVO::getNgOwner).distinct().collect(Collectors.toList()

List<ActivityTemplate>activityTemplateList=activityTemplateService.list(Wrappers.<ActivityTemplate>lambdaQuery()
.eq(ActivityTemplate::getPlanTemplateId,planTemplate.getId()));


// // 1.排序，带参数类型
// list.sort((String s1, String s2) -> s1.compareTo(s2));
// list.sort(( LibraryDO lib1, LibraryDO lib2) -> lib2.getId().compareTo(lib2.getId()));
// // 使用默认方法排序
// Collections.sort(list, Comparator.comparing(LibraryDO::getId)); //升序
// Collections.reverse(list); // 倒序排列
// //随机打乱顺序
// Collections.shuffle(list);
// //更多排序
// //默认ASC排序）
// List<LibraryDO> collect = users.stream().sorted(Comparator.comparing(LibraryDO::getId)).collect(Collectors.toList());
// //DESC排序）
// List<LibraryDO> collect = users.stream().sorted(Comparator.comparing(LibraryDO::getId).reversed()).collect(Collectors.toList());

// // 2.数组去重
// List<String> collect = list.stream().distinct().collect(Collectors.toList());
// // 数组去重转换为字符串
// String joining = list.stream().distinct().collect(Collectors.joining(",")); 
// // 根据对象属性去重
// List<LibraryDO> lib = list.stream().collect(Collectors.collectingAndThen(
// 					Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(LibraryDO::getId))), ArrayList<LibraryDO>::new));

// // 4.获取对象某一属性返回list
// List<String> collect= list.stream().map(LibraryDO::getId).collect(Collectors.toList());
// // 获取对象某一属性返回数组
// Integer[] array = list.stream().map(LibraryDO::getId).collect(Collectors.toList()).stream().toArray(Integer[]::new);
// // 获取对象某一属性返回数组过滤非空
// Integer[] array = list.stream().map(LibraryDO::getId).filter(x -> x !=null).collect(Collectors.toList()).stream().toArray(Integer[]::new);
// //5.修改对象属性值
// List<LibraryDO> lib = list.stream().map(p -> {p.setId(p.getId() + 1);return p;}).collect(Collectors.toList())


// Map<String, List<String>> locationMap = locations.stream()
//         .map(s -> s.split(":"))
//         .collect(Collectors.groupingBy(a -> a[0],
//                 Collectors.mapping(a -> a[1], Collectors.toList())));
// Map<String,List<ProblemInstanceExtendVo>>problemsByDomain=problemList.stream().collect(Collectors.groupingBy(ProblemInstanceExtendVo::getProblemDomain));
// 来自 <https://stackoverflow.com/questions/56389575/how-to-convert-liststring-to-mapstring-liststring-based-on-a-delimeter/56389633> 


// /**
// ————————————————
// 版权声明：本文为CSDN博主「代码不是马」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/lyp1245387976/article/details/105127290

// Map<String, String> instanceMap = baseInfo.stream().collect(Collectors.toMap(ComponentVo::getCode, ComponentVo::getValue));
 
// objInstanceService.removeByIds(instanceSonList.stream().map(ObjInstance::getId).collect(Collectors.toList()));

// List<String> queryParams = list.stream().map(CheckListVO::getNgOwner).distinct().collect(Collectors.toList()

// List<ActivityTemplate>activityTemplateList=activityTemplateService.list(Wrappers.<ActivityTemplate>lambdaQuery()
// .eq(ActivityTemplate::getPlanTemplateId,planTemplate.getId()));

class Two {
	static int l = 0;
	One one_1 = new One("one-1");
	static One one_2 = new One("one-2");
	static One one_3 = new One("one-3");

	Two(String str) {
		System.out.println(str);
	}
}

public class TestString {
	public static void main(String[] arg) {
		System.out.println("Two.i=" + Two.l);
		System.out.println("Two.i=" + Two.l);
		
		System.out.println("---题2----------------" );
		//另外的题2 begin
		String a=new String("a");//开辟一块新的内存使用
		String b="a";
		String c="a";//b、c是共用的一块内存,只要对象信息一样就是同一块内存，不一样就会开辟新的
		System.out.println(a==b);
		System.out.println(b==c);//为什么是true呢
		//另外的题2 end
		//考的是内存分配的问题
		

		System.out.println("---题3----------------" );
		String str1 = new String("ABC");
		String str2 = new String("ABC");
		System.out.println(str1==str2);
		System.out.println("---题4----------------" );
		String str3 = "ABC";
		String str4 = "ABC";
		String str5 = "A" + "BC";
		System.out.println(str3==str4);
		System.out.println(str4==str5);

		System.out.println("---题5----------------" );
		String aa = "ABC";
		String bb="AB";
		String cc=bb+"C";
		System.out.println(aa==cc);
		/*a和b都是字符串常量所以在编译期就被确定了！
		而c中有个b是引用不是字符串常量所以不会在编译期确定。
		而String是final的！所以在b+"c"的时候实际上是新创建了一个对象，然后在把新创建对象的引用传给c.*/
		System.out.println("---题6-----test --/++ -----------" );
		int x=1,y=2,z=3;
		System.out.println(y+=z--/++x );
		System.out.println("---题7-----test --/++ -----------" );
		int xx=2;
		System.out.println((xx++)/3);
		
		System.out.println("---题8-----关系运算-----------" );
		int yy=10;
		yy+=yy-=yy-yy;
		System.out.println(yy);
		System.out.println("---题9-----boolean运算-----------" );
		Boolean m=true;
		if(m==false)
		System.out.println("False");
		else
		System.out.println("True");
		

	}
}
/*考的是静态方法
 * 答案
 * 
one-2
one-3
Two.i=0
Two.i=0
 */



