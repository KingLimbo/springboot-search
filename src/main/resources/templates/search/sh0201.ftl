<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../base/header.ftl" />
    <style>
        option:disabled {
            background-color: #eee;
        }
    </style>
</head>
<body>
<div class="container-fluid" id="container">
    <div class="page-header">
        <h1>查询演示</h1>
    </div>
    <form class="form-horizontal" id="form">
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="schame" class="col-sm-4 control-label">数据库：</label>
                    <div class="col-sm-8">
                        <select class="form-control" name="schame" v-model="schame" v-on:change="listTables">
                            <option v-for="option in schameOptions" v-bind:value="option.value">{{ option.text }}</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="table" class="col-sm-4 control-label">业务表：</label>
                    <div class="col-sm-8">
                        <select class="form-control" name="table" v-model="table" v-on:change="listCloumns">
                            <option v-for="option in tableOptions" v-bind:value="option.value">{{ option.text }}</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" @click="addConditionDiv" class="btn btn-default">添加查询条件</button>
            </div>
        </div>

        <div class="form-group"v-for="(d,index) in conditions" v-bind:key="index">
            <label for="cloumn" class="col-sm-2 control-label">条件：</label>
            <div class="col-sm-3">
                <select class="form-control" name="cloumn" @change="showCondition">
                    <option v-for="option in cloumns" v-bind:value="option.cloumn" v-bind:data-type="option.dataType">{{ option.cloumnName }}</option>
                </select>
            </div>
            <div class="col-sm-2">
                <select class="form-control" @change="updateCondition">
                    <option v-for="option in calculationOptions" v-bind:value="option.value">{{ option.text }}</option>
                </select>
            </div>
            <div class="col-sm-4" name="search_value">
                <input data-calculation="01" data-placeholder="" type="text" class="form-control" id="" placeholder="请输入字符">
            </div>
            <div class="col-sm-1">
                <button type="button" class="btn btn-danger" @click="deletePerson">删除</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-11 col-sm-1">
                <button type="button" class="btn btn-primary" @click="search">查询</button>
            </div>
        </div>
    </form>

    <div class="page-header">
        <h1>数据显示</h1>
    </div>
    <table id="demo" lay-filter="test"></table>

</div>
<#include "../base/footer.ftl" />
<script src="${ctx}/assets/search/sh0201.js"></script>
</body>
</html>