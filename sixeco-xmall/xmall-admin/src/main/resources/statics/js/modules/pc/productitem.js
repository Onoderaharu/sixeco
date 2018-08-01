$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pc/productitem/page',
        datatype: "json",
        colModel: [			
			{ label: 'productItemId', name: 'productItemId', index: 'product_item_id', width: 50, key: true },
			{ label: '', name: 'productId', index: 'product_id', width: 80 }, 			
			{ label: '第一层分类   车身', name: 'level1Type', index: 'level1_type', width: 80 }, 			
			{ label: '第二层分类   车顶', name: 'level2Type', index: 'level2_type', width: 80 }, 			
			{ label: '第三层分类   内饰', name: 'level3Type', index: 'level3_type', width: 80 }, 			
			{ label: '第四层分类   电池', name: 'level4Type', index: 'level4_type', width: 80 }, 			
			{ label: '第五层分类   电池包', name: 'level5Type', index: 'level5_type', width: 80 }, 			
			{ label: '第六层分类   选装手动空调', name: 'level6Type', index: 'level6_type', width: 80 }, 			
			{ label: '第七层分类   电机', name: 'level7Type', index: 'level7_type', width: 80 }, 			
			{ label: '车系', name: 'subtype2', index: 'subtype2', width: 80 }, 			
			{ label: '车型', name: 'subtype', index: 'subtype', width: 80 }, 			
			{ label: '价格', name: 'price', index: 'price', width: 80 }, 			
			{ label: '描述', name: 'description', index: 'description', width: 80 }, 			
			{ label: '其他信息', name: 'others', index: 'others', width: 80 }, 			
			{ label: '是否删除  0:未删 1:已删', name: 'isDeleted', index: 'is_deleted', width: 80 }, 			
			{ label: '是否使用(上下架)0 - 否(下架)1 - 是(上架)', name: 'isUse', index: 'is_use', width: 80 }, 			
			{ label: '0整车1周边', name: 'type', index: 'type', width: 80 }, 			
			{ label: '', name: 'isDefault', index: 'is_default', width: 80 }, 			
			{ label: '商品编号', name: 'productCode', index: 'product_code', width: 80 }, 			
			{ label: '商品库存', name: 'inventory', index: 'inventory', width: 80 }, 			
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
		productItem: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.productItem = {};
		},
		update: function (event) {
			var productItemId = getSelectedRow();
			if(productItemId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(productItemId)
		},
		saveOrUpdate: function (event) {
			var url = vm.productItem.productItemId == null ? "pc/productitem/save" : "pc/productitem/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.productItem),
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
			var productItemIds = getSelectedRows();
			if(productItemIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pc/productitem/delete",
                    contentType: "application/json",
				    data: JSON.stringify(productItemIds),
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
		getInfo: function(productItemId){
			$.get(baseURL + "pc/productitem/info/"+productItemId, function(r){
                vm.productItem = r.productItem;
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