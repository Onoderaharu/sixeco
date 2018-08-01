$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pc/category/page',
        datatype: "json",
        colModel: [			
			{ label: 'categoryId', name: 'categoryId', index: 'category_id', width: 50, key: true },
			{ label: '父分类ID', name: 'parentId', index: 'parent_id', width: 80 }, 			
			{ label: '分类名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '排序', name: 'sort', index: 'sort', width: 80 }, 			
			{ label: '目录类型 2=二级目录/1=一级目录/0=总目录', name: 'type', index: 'type', width: 80 }, 			
			{ label: '状态 1=显示/0=隐藏', name: 'status', index: 'status', width: 80 }, 			
			{ label: '是否推荐（0：不推荐 1：推荐）', name: 'showInCommend', index: 'show_in_commend', width: 80 }, 			
			{ label: '是否导航栏 1=显示/0=隐藏', name: 'showInNav', index: 'show_in_nav', width: 80 }, 			
			{ label: '是否置顶 1=置顶/0=默认', name: 'showInTop', index: 'show_in_top', width: 80 }, 			
			{ label: '是否热门 1=热门/0=默认', name: 'showInHot', index: 'show_in_hot', width: 80 }, 			
			{ label: '分类小图标', name: 'icon', index: 'icon', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建者', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '更新者', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '页面标题', name: 'pageTitle', index: 'page_title', width: 80 }, 			
			{ label: '页面描述', name: 'pageDescription', index: 'page_description', width: 80 }, 			
			{ label: '页面关键词', name: 'pageKeyword', index: 'page_keyword', width: 80 }, 			
			{ label: '备注信息', name: 'remarks', index: 'remarks', width: 80 }, 			
			{ label: '频道id', name: 'channelId', index: 'channel_id', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		category: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.category = {};
		},
		update: function (event) {
			var categoryId = getSelectedRow();
			if(categoryId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(categoryId)
		},
		saveOrUpdate: function (event) {
			var url = vm.category.categoryId == null ? "pc/category/save" : "pc/category/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.category),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var categoryIds = getSelectedRows();
			if(categoryIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pc/category/delete",
                    contentType: "application/json",
				    data: JSON.stringify(categoryIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(categoryId){
			$.get(baseURL + "pc/category/info/"+categoryId, function(r){
                vm.category = r.category;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});