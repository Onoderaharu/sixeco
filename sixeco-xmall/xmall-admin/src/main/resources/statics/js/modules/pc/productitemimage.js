$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pc/productitemimage/page',
        datatype: "json",
        colModel: [			
			{ label: 'productItemImageId', name: 'productItemImageId', index: 'product_item_image_id', width: 50, key: true },
			{ label: '商品配置id', name: 'productItemId', index: 'product_item_id', width: 80 }, 			
			{ label: '商品id', name: 'productId', index: 'product_id', width: 80 }, 			
			{ label: '资源路径url', name: 'url', index: 'url', width: 80 }, 			
			{ label: '文件类型', name: 'fileType', index: 'file_type', width: 80 }, 			
			{ label: '标签', name: 'tag', index: 'tag', width: 80 }, 			
			{ label: '配置需要vsn编码', name: 'vsn', index: 'vsn', width: 80 }, 			
			{ label: '1主图、2封面、3详情、4参数、5配置  （配置需要vsn编码）', name: 'type', index: 'type', width: 80 }, 			
			{ label: '1整车2周边', name: 'classify', index: 'classify', width: 80 }			
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
		productItemImage: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.productItemImage = {};
		},
		update: function (event) {
			var productItemImageId = getSelectedRow();
			if(productItemImageId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(productItemImageId)
		},
		saveOrUpdate: function (event) {
			var url = vm.productItemImage.productItemImageId == null ? "pc/productitemimage/save" : "pc/productitemimage/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.productItemImage),
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
			var productItemImageIds = getSelectedRows();
			if(productItemImageIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pc/productitemimage/delete",
                    contentType: "application/json",
				    data: JSON.stringify(productItemImageIds),
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
		getInfo: function(productItemImageId){
			$.get(baseURL + "pc/productitemimage/info/"+productItemImageId, function(r){
                vm.productItemImage = r.productItemImage;
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