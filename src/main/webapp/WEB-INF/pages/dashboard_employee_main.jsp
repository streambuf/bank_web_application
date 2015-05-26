<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>
        <spring:message code="application.name"/>
    </title>
</head>
<body>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Главная
                <small></small>
            </h1>

        </section>

        <!-- Main content -->
        <section class="content">
            <!-- Small boxes (Stat box) -->
            <section class="content">
                <div class="row">
                    <div class="col-md-3">
                        <div class="box box-solid">
                            <div class="box-header with-border">
                                <h3 class="box-title">Меню</h3>
                            </div>
                            <div class="box-body no-padding">
                                <ul class="nav nav-pills nav-stacked">
                                    <li class="active"><a href="#"><i class="fa fa-inbox"></i> Входящие <span class="label label-primary pull-right">12</span></a></li>
                                    <li><a href="#"><i class="fa fa-envelope-o"></i> Отправленные</a></li>
                                    <li><a href="#"><i class="fa fa-file-text-o"></i> Черновики</a></li>
                                    <li><a href="#"><i class="fa fa-filter"></i> Избранные <span class="label label-waring pull-right">65</span></a></li>
                                    <li><a href="#"><i class="fa fa-trash-o"></i> Корзина</a></li>
                                </ul>
                            </div><!-- /.box-body -->
                        </div><!-- /. box -->

                    </div><!-- /.col -->
                    <div class="col-md-9">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">Входящие</h3>
                                <div class="box-tools pull-right">
                                    <div class="has-feedback">
                                        <input type="text" class="form-control input-sm" placeholder="Поиск"/>
                                        <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                    </div>
                                </div><!-- /.box-tools -->
                            </div><!-- /.box-header -->
                            <div class="box-body no-padding">
                                <div class="mailbox-controls">
                                    <!-- Check all button -->
                                    <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                    </div><!-- /.btn-group -->
                                    <button class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                    <div class="pull-right">
                                        1-50/200
                                        <div class="btn-group">
                                            <button class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                            <button class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                        </div><!-- /.btn-group -->
                                    </div><!-- /.pull-right -->
                                </div>
                                <div class="table-responsive mailbox-messages">
                                    <table class="table table-hover table-striped">
                                        <tbody>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">5 минут назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">28 минут назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">11 часов назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">15 часов назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">Вчера</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">2 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">2 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">2 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">2 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">2 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">4 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"></td>
                                            <td class="mailbox-date">12 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">12 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">14 дней назад</td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" /></td>
                                            <td class="mailbox-star"><a href="#"><i class="fa fa-star text-yellow"></i></a></td>
                                            <td class="mailbox-name"><a href="#">${user.lname} ${user.fname}</a></td>
                                            <td class="mailbox-subject"><b>Тема письма</b> - Требуется решить следующую проблему ...</td>
                                            <td class="mailbox-attachment"><i class="fa fa-paperclip"></i></td>
                                            <td class="mailbox-date">15 дней назад</td>
                                        </tr>
                                        </tbody>
                                    </table><!-- /.table -->
                                </div><!-- /.mail-box-messages -->
                            </div><!-- /.box-body -->
                            <div class="box-footer no-padding">
                                <div class="mailbox-controls">
                                    <!-- Check all button -->
                                    <button class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button>
                                    <div class="btn-group">
                                        <button class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                                        <button class="btn btn-default btn-sm"><i class="fa fa-share"></i></button>
                                    </div><!-- /.btn-group -->
                                    <button class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button>
                                    <div class="pull-right">
                                        1-50/200
                                        <div class="btn-group">
                                            <button class="btn btn-default btn-sm"><i class="fa fa-chevron-left"></i></button>
                                            <button class="btn btn-default btn-sm"><i class="fa fa-chevron-right"></i></button>
                                        </div><!-- /.btn-group -->
                                    </div><!-- /.pull-right -->
                                </div>
                            </div>
                        </div><!-- /. box -->
                    </div><!-- /.col -->
                </div><!-- /.row -->

        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <!-- add class .active for li[num] in sidebar-menu -->
    <input id="meta.page.li.num" type="hidden" value="1" />
</body>

<div id="javascript">

</div>

</html>