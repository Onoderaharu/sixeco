$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + '/gooditem/page',
        datatype: "json",
        colModel: [			
			{ label: 'Id', name: 'productItemId', index: 'product_item_id', width: 50, key: true },
			{ label: '产品编号', name: 'productId', index: 'product_id', width: 80 }, 			
			{ label: '车身', name: 'level1Type', index: 'level1_type', width: 80 }, 			
			{ label: '车顶', name: 'level2Type', index: 'level2_type', width: 80 }, 			
			{ label: '内饰', name: 'level3Type', index: 'level3_type', width: 80 }, 			
			{ label: '电池', name: 'level4Type', index: 'level4_type', width: 80 }, 			
			{ label: '电池包', name: 'level5Type', index: 'level5_type', width: 80 }, 			
			{ label: '空调', name: 'level6Type', index: 'level6_type', width: 80 }, 			
			{ label: '电机', name: 'level7Type', index: 'level7_type', width: 80 }, 			
			{ label: '车系', name: 'subtype2', index: 'subtype2', width: 80 }, 			
			{ label: '车型', name: 'subtype', index: 'subtype', width: 80 }, 			
			{ label: '价格', name: 'price', index: 'price', width: 80 }, 			
			{ label: '商品描述', name: 'description', index: 'description', width: 80 }, 			
			{ label: '补充', name: 'others', index: 'others', width: 80 }, 			
			{ label: '是否删除', name: 'isDeleted', index: 'is_deleted', width: 80 }, 			
			{ label: '是否上架', name: 'isUse', index: 'is_use', width: 80 }, 			
			{ label: '整车/周边', name: 'type', index: 'type', width: 80 }, 			
			{ label: '是否', name: 'isDefault', index: 'is_default', width: 80 }, 			
			{ label: '商品编号', name: 'productCod', index: 'product_cod', width: 80 }, 			
			{ label: '库存配置', name: 'inventory', index: 'inventory', width: 80 }, 			
			{ label: 'vsn编码', name: 'vsn', index: 'vsn', width: 80 }			
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
		goodItem: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goodItem = {};
		},
		update: function (event) {
			var productIte = getSelectedRow();
			if(productIte == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(productIte)
		},
		saveOrUpdate: function (event) {
			var url = vm.goodItem.productIte == null ? "/gooditem/save/json" : "/gooditem/update/json";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goodItem),
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
			var productItes = getSelectedRows();
			if(productItes == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "/gooditem/delete",
                    contentType: "application/json",
				    data: JSON.stringify(productItes),
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
		getInfo: function(productIte){
			$.get(baseURL + "/gooditem/info/"+productIte, function(r){
                vm.goodItem = r.goodItem;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:vm.gooditem,
                page:page
            }).trigger("reloadGrid");
		}
	}
});