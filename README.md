# micro services

这个仓库是管理着所有的微服务以及它的依赖，现有服务：

- 标的服务(bid)
- 营销服务(marketing)
- [PMS服务](https://gitlab.fenlibao.com/f_java/pms-service) (pms-service)
- 用户服务(user)
- 新网服务(xinwang)
- 待添加

## 结构解析

```text
micro services
├─bid 标的服务
├─common-core 常用核心项目
├─common-model 常用类
│  ├─model-base 基础类
│  └─model-pms PMS相关的类（PO、Response、Request）
├─common-parent 所有项目的父级
├─marketing 营销服务
├─pms-service PMS后台服务
├─user 用户服务
└─xinwang 新网服务
```

> common-parent

这个项目管理着项目中所有的依赖，在引入新的jar包时，应该先添加到parent中的pom文件中并且规定好版本号，之后再添加到项目中。

> common-core

这里管理着常用的工具、枚举、异常类等等。

> common-model

这里管理着其他项目也可能会使用到其他服务的实体类，当你有新增PO、Req、Resp类时，应该添加到这个目录中，方便其他项目使用。

> model-base

将常用的类放到这个项目中。

## Git多项目管理

由于我们采用的是Gitlab+Jenkins+Docker来实现自动化部署，但是我们将项目一些相关的依赖已经拆分成为了一个个独立的项目。为了解决当个项目的自动化部署，我们采用git子模块的形式来管理项目。

### 新建Git子模块

首先，你需要建立一个公共仓库，项目的归属应该选择的是`f_java`这个组织，而不是个人。创建好了之后fork一份到你自己的空间，你可以选择拉取代码到本地，然后进行开发。如果你不想拉取也可以，不过在开发的过程中，你就需要打开`micro-services`项目进行开发。

#### 使用git subtree命令

git subtree的命令主要有：

```git
git subtree add   -P <prefix> <commit>
git subtree add   -P <prefix> <repository> <ref>
git subtree pull  -P <prefix> <repository> <ref>
git subtree push  -P <prefix> <repository> <ref>
git subtree merge -P <prefix> <commit>
git subtree split -P <prefix> [OPTIONS] [<commit>]
```

建立好了新的项目后，你需要在`micro-services`项目中添加子项目，这里我用`pms-service`做示范：

```git
$ git remote add -f pms-service-upstream ssh://git@gitlab.fenlibao.com:10086/f_java/pms-service.git

$ git remote add -f pms-service-origin ssh://git@gitlab.fenlibao.com:10086/leixinxin/pms-service.git #个人的仓库

$ git subtree add -P pms-service ssh://git@gitlab.fenlibao.com:10086/f_java/pms-service.git master --squash
```

这样，就将一个子项目添加到了项目中。

`--squash`参数表示不拉取历史信息，而只生成一条commit信息。

##### 将代码提交到子项目

添加完后，如果有进行修改，并且需要推送到子项目的仓库中，你可以使用下面的命令：

```git
$ git add .

$ git commit -m "update README.md"

$ git subtree push -P pms-service pms-service-origin dev --squash
```

这样就提及到了子项目中。

##### 拉取子项目的代码

由于我们是多人协作开发，一个项目可能会有多个人进行开发，所以为了保持代码的一致，我们需要拉取远程仓库中的代码：

```git
$ git subtree pull -P pms-service pms-service-upstream dev --squash
```

这样就基本大功告成啦！更多详细的命令可以通过`git substree --help`查看。