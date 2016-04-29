<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <link href="${__static__}/css/public.css" type="text/css" rel="stylesheet">
        <link href="${__static__}/css/houtai.css" type="text/css" rel="stylesheet">
        <link href="${__static__}/css/smartMenu.css" type="text/css" rel="stylesheet">
<title>打分系统</title>
<script type="text/javascript">
	var ZLZ = window.ZLZ = {
		"ROOT" : "${__root__}",
		"URL" : "${__url__}",
		"STATIC" : "${__static__}"
	}
</script>
</head>
<body>
    	<div id="admin">
    		<div class="ad-menu" id="ad-menu">
                <div class="ad-logo"><img src="${__static__}/images/m-logo.png" height="103" width="130"></div>
                <div class="ad-list">
                    <ul>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic1"></em><spring:message code="left.User.Center"/><span class="scm arrow"></span></div>
                            <dl>
                                 <dd>
                                    <a href="info" class="dd-item" target="iframe0"><spring:message code="left.User.Info" /><span class="scm dd-ar"></span></a>
                             
                                </dd>
                                <dd>
                                    <a href="change_pass" class="dd-item" target="iframe0"><spring:message code="left.User.Modify_Password" /><span class="scm dd-ar"></span></a>
                                   
                                </dd>
                                <dd>
                                    <a href="prove" class="dd-item" target="iframe0"><spring:message code="left.User.Security.Question.Modification" /><span class="scm dd-ar"></span></a>
                                   
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic2"></em><spring:message code="left.Project.Manage" /><span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item"><spring:message code="left.MyProject"/><span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="join" class="dd-item" target="iframe0"><spring:message code="left.MyJoin.Project"/><span class="scm dd-ar"></span></a>
                                </dd>
                             <dd>
                                    <a href="add" class="dd-item" target="iframe0"><spring:message code="left.Start.Project"/><span class="scm dd-ar"></span></a>
                                </dd>
                              <!--  <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd> -->
                            </dl>
                        </li>
                        <li>
                         <!--    <div class="li-item"><em class="scm li-ico ic3"></em>啊啊啊啊<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">校友高级管理<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
                                        <li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
                                        <li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
                                        <li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
                                        <li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
                                        <li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
                                        <li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
                                        <li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
                                        <li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
                                        <li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
                                        <li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友查询<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
                                        <li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
                                        <li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
                                        <li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
                                        <li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
                                        <li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
                                        <li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
                                        <li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
                                        <li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
                                        <li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
                                        <li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友搜索<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
                                        <li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
                                        <li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
                                        <li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
                                        <li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
                                        <li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
                                        <li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
                                        <li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
                                        <li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
                                        <li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
                                        <li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高输入<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
                                        <li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
                                        <li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
                                        <li class="J_menuItem" href="index_v4.html" data-index="4">测试用例四</li>
                                        <li class="J_menuItem" href="index_v5.html" data-index="5">测试用例五</li>
                                        <li class="J_menuItem" href="index_v6.html" data-index="6">测试用例六</li>
                                        <li class="J_menuItem" href="index_v7.html" data-index="7">测试用例七</li>
                                        <li class="J_menuItem" href="index_v8.html" data-index="8">测试用例八</li>
                                        <li class="J_menuItem" href="index_v9.html" data-index="9">测试用例九</li>
                                        <li class="J_menuItem" href="index_v10.html" data-index="10">测试用例十</li>
                                        <li class="J_menuItem" href="index_v11.html" data-index="11">测试用例十一</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic4"></em>社区管理<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic5"></em>捐赠管理<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic6"></em>统计管理<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic7"></em>系统管理<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">校友高级搜索<span class="scm dd-ar"></span></a>
                                </dd>
                            </dl>
                        </li>-->
                    </ul> 
                </div>
            </div>
    		<div class="ad-comment-box" id="ad-comment">
                <div class="ad-top-comment">
                    <div class="ad-message">
                        <div class="ad-top-left">
                            <div class="ad-change-btn"><a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a></div>
                            <div class="ad-search-box clear">
                                <div class="ad-search-sel">
                                    <select>
                                        <option>新闻类</option>
                                        <option>新闻吩咐道类</option>
                                        <option>新闻广告费类</option>
                                        <option>新闻苟富贵类</option>
                                    </select>
                                </div>
                                <div class="ad-search-cha">
                                    <input type="text" class="ad-search-input" placeholder="请输入你要查找的内容">
                                    <input type="submit" class="scm ad-search-btn" value=""> 
                                </div>
                            </div>
                        </div>
                        <div class="ad-top-right">
                            <div class="ad-notice">
                                <ul>
                                    <li>
                                        <a href="javascript:;" class="scm nt1"><span class="scm nt-count dot">12</span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" class="scm nt2"><span class="scm nt-count dot">12</span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" class="scm nt3"><span class="scm nt-count dot">12</span></a>
                                    </li>
                                </ul>
                            </div>
                            <div class="ad-welcom">
                                <div class="ad-wel-img"><img src="${__static__}/images/min_logo.png" height="36" width="36"></div>
                                <div class="ad-wel-text">
                                    <div class="font-wel"><spring:message code="top.welcome"/><strong>${sessionScope.name}</strong>	<a href="${z:u('/') }?language=${language=='zh_CN'?'en':'zh_CN' }" class="language">${language=='zh_CN'?'English':'Chinese' }</a></div>
                                    <div class="font-wel"><a href='${z:u("logout")}'><strong>【退出】</strong></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ad-main-nav-box">
                        <ul id="breadcrumbs-three">
                            <li title="首页"><a href="javascript:;" class="dot"><spring:message code="top.index"/></a></li>
                        </ul>
                        <a href="javascript:;" class="scm jian-a J_mainLeft main-sel pre"></a>
                        <div class="ad-main-wraper .J_menuItems">
                            <ul class="ad-main-list" id="ad-main">
                            </ul>
                        </div>
                        <a href="javascript:;" class="scm jian-a J_mainRight next"></a>
                    </div>
                    <div class="ad-sub-nav-box content-tabs">
                        <!-- <div class="ad-sub-record">历史记录</div> -->
                        <a href="javascript:;" class="scm jian-a sub-sel pre j_tabBg J_tabLeft"></a>
                        <div class="ad-sub-wraper page-tabs J_menuTabs">
                            <ul class="ad-sub-list page-tabs-content">
                                <li class="active J_menuTab" data-id="index_v0.html"><spring:message code="top.index"/></li>
                            </ul>
                        </div>
                        <a href="javascript:;" class="scm jian-a next j_tabBg J_tabRight"></a>
                    </div>
                </div>
                <div class="ad-main-comment J_mainContent" id="ad-iframe">
                    <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_v0.html" frameborder="0" data-id="index_v0.html" seamless></iframe>
                </div>
    		</div>
    	</div>
        <script type="text/javascript" src="${__static__}/js/jquery.min.js"></script>
        <script type="text/javascript" src="${__static__}/js/contabs.js"></script>
        <script type="text/javascript" src="${__static__}/js/maintabs.js"></script>
        <script type="text/javascript" src="${__static__}/js/jquery-smartMenu-min.js"></script>
        <script type="text/javascript" src="${__static__}/js/jquery.nicescroll.min.js"></script>
        <script type="text/javascript">
            $(function(){
                $(".ad-menu").niceScroll({cursorborder:"0 none",cursorcolor:"#1a1a19",cursoropacitymin:"0",boxzoom:false});
            })
        </script>
    </body>
</html>