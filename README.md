# bookSystem

## 这是二阶段测试做的考试项目
### 一天之内完成
#### 要求如下

题目：图书查询(时间：9：00—16：00)
一、语言和环境
A、	实现语言  
Java
B、	环境要求
JDK1.8、MyEclipse2016、Tomcat8.0、MySQL5.5
二、数据库设计
数据库名称：bookDB，包含两张表：图书类型表(bookType)和图书信息表(bookInfo)。
表1 图书类型表（bookType）
字段名称	字段说明	类型	备注
typeId	类型编号	int	自动增长列、主键
typeName	类型名称	varchar(20)	非空
表2 图书信息表(bookInfo)
字段名称	字段说明	类型	备注
bookId	图书编号	int	自动增长列、主键
bookName	图书名称	varchar(20)	非空
typeId	图书类型	int	外键，非空
Author	作者	varchar(50)	非空
Publisher	出版社	varchar(50)	非空
publishTime	出版时间	datetime	非空
Count	库存数量	int	非空
Remark	备注	varchar(200)	
三、要求
公司计划开发一个图书管理系统，其中图书查询功能由你来负责。要求基于Java Web技术，在原有项目上进行开发，使用MySQL作为后台数据库，功能包括图书查询。具体页面要求如下：
1、	图书查询页面主要包含一个文本框、下拉列表框和一个查询按钮，下拉列表框中的数据从数据库中获取。如图1所示。
 
图1 图书查询页面
2、	当用户填写了图书名称、选择了图书类别，并点击查询按钮，界面效果如图2所示。将查询出指定类别的图书信息。（提示：图1所示的查询页面下方包含一个iframe，只是初始化时并未设置其src的值，且iframe无边框，所以不可见。当用户点击查询按钮时，使用JavaScript获取表单数据并设置iframe的src的值，将表单数据通过URL传值的方式传递至iframe所包含的页面。）
 
图2 查询效果-图书列表
3、	图书查询是根据输入的图书名称或关键字进行模糊查询，并且不区分大小写，查询关键字java的效果。如图3所示。
 
图3 模糊查询效果
4、	若填写了图书名称，却没有找到相关图书信息，则显示如图4所示。
 
图4 未找到满足条件的图书信息时
5、	若图书类别选择为全部且图书名称未填写，将查询全部的数据（请注意：不要求实现分页）。如图5所示。
 
图5 查询全部图书效果
6、	在操作列中包含一个详情超链接，单击该链接将切换到对应的图书详细信息页面，如图6所示。在该页面中还包含一个返回链接，点击该链接将返回至图书列表页面。
 
图6 详细信息页面
四、推荐实现步骤
1、		建立数据库bookDB，创建数据表bookType和bookInfo，并插入测试数据。（5分）
2、	在MyEclipse中新建Web项目bookSystem，导入数据库驱动包、DbUtils等其他工具包，在源文件夹中创建三成架构需要的程序包。（5分）
3、	在utils包下创建数据访问工具类C3p0Utils.java,该类中包含获取连接池、获取连接和关闭连接的静态方法；在doman包中建立与数据库中bookInfo表对应的实体类BookInfo.java和bookType表对应的实体类BookType.java。（10分）
4、	创建DAO接口和类：接口BookInfoDao.java，实现类BookInfoDaoImpl.java。(10分)
（1）	建立根据图书名称和图书类别查询的方法findBook(...)，返回实体集合。
（2）	建立根据图书编号查询的方法findBookById(...)，返回实体对象。
5、	创建DAO接口和类：接口BookTypeDao.java，实现类BookTypeDaoImpl.java。(10分)
（1）	建立查询所有图书类别的方法findBookType(...)，返回实体类集合对象。
6、	创建业务层接口和实现类，并完成相应功能。（5分）
7、	创建图书查询的JSP页面(index.jsp)。（10分）
（1）	在JSP页面中添加图书名称文本框和下拉列表框，访问FindBookTypeServlet，调用BookTypeDao的findBookType()方法查询出图书类型,转发到index.jsp页面并显示在下拉列表框中
（2）	在JSP页面中添加iframe，默认不指定src属性
（3）	编写JavaScript脚本函数，用于获取图书名称文本框和下拉列表框的值，并设置iframe的src属性，将获取的数据传递至FindBookServlet，并模糊查询相应图书，转发至books.jsp。
8、	创建显示图书列表的JSP页面（books.jsp）。（10分）
（1）	使用EL表达式和JSTL显示图书信息。
（2）	注意“详情”超链接应该向详细信息页面传递不同的图书编号
（3）	过滤器解决中文乱码问题
9、	创建显示图书详细信息的JSP页面(bookInfo.jsp)，根据传递的图书编号进行查询。（5分）
10、	扩展功能1：在操作中一栏中加入删除和修改功能并实现分页功能如下图所示（15分）
 
11、	扩展功能2：”删除”使用ajax技术实现，功能要有提示，“确定要删除吗?”，删除后页面中数据及时更新。（8）
12、	点击“修改”跳转至“修改页面”，修改页面自己添加，没有界面要求，实现修改功能，修改成功后跳到“查询页面”。（7）
13、	调试运行成功后，将数据库SQL语句文件与代码文件一同提交。
