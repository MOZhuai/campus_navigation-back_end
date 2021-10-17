## 《校园考场导航系统》配置说明

### 一、  运行环境

​	Mysql版本：Server version: 8.0.16 MySQL Community Server - GPL

​	Android Studio版本：4.1

​	Gradle版本：4.1.0

​	JDK：1.8.0_161

​	Unity版本：2019.4.18f1c1

​	Tomcat版本：8.5.43

​	Intellij IDEA版本：2019.3

​	系统环境：Windows10 专业版

​	安卓版本：9.0（10.0无法使用，因为百度步行导航目前不支持高版本）

### 二、  数据库配置

​	文件路径：“\数据库文件\ schoolNav.sql”

​	该文件包含建库、建表语句，通过mysql调用该文件即可。

### 三、  后台项目部署说明

​	文件路径：“\后台项目文件\ mobileapp”

​	打开项目后，需要配置数据库信息，数据库配置文件位于“\mobileapp\src\main\resources\dbconfig.properties”，将四项配置信息替换后，导出war包并置于tomcat服务器中运行，或在配置好tomcat 的Intellij IDEA中直接运行即可。

### 四、  Unity项目文件说明

​	该项目文件不用于部署，主要通过Android Studio调用其导出的SDK包，即“地图录入员端”和“考生端”文件夹下的“ar”文件夹。

​	若要编辑该项目，需将项目文件“Unity项目文件\ SchoolNav”通过unity平台打开，建议平台版本与“运行环境”中的版本一致。

### 五、  考生端（地图录入员端）部署说明

​	考生端和地图录入员端配置过程一致。

​	在文件夹“考生端”下包含两个项目文件：其中“ar”为unity项目导出后的sdk包；“SchoolNav”为安卓应用的主要项目文件，通过Android Studio打开该项目即可。由于需要访问后台的接口，并且安卓的okhttp请求无法通过“localhost”来代替本机IP，所以项目内需要配置后台的IP，IP配置文件位于“\SchoolNav\app\src\main\java\com\schoolnav\constant\RequsetSetting.java”，将该类中的IP值修改为部署环境的IP即可。

### 六、  校园管理员端部署说明

​	项目路径：“\校园管理端\SchoolNavigation”

​	该部分为前端页面，部署时可按需配置后台请求的IP，项目文件中默认为localhost，配置信息位于“\SchoolNavigation\js\index.js”第一行。