$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'province/page',
        datatype: "json",
        colModel: [			
			{ label: 'provinceId', name: 'provinceId', index: 'province_id', width: 50, key: true },
			{ label: '省份名称', name: 'provinceName', index: 'province_name', width: 80 }, 			
			{ label: '区域名称', name: 'area', index: 'area', width: 80 }, 			
			{ label: '区域编码', name: 'provinceCode', index: 'province_code', width: 80 }			
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
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
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
		province: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.province = {};
		},
		update: function (event) {
			var provinceId = getSelectedRow();
			if(provinceId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(provinceId)
		},
		saveOrUpdate: function (event) {
			var url = vm.province.provinceId == null ? "province/save/json" : "province/update/json";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.province),
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
			var provinceIds = getSelectedRows();
			if(provinceIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "province/delete",
                    contentType: "application/json",
				    data: JSON.stringify(provinceIds),
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
		getInfo: function(provinceId){
			$.get(baseURL + "province/info/"+provinceId, function(r){
                vm.province = r.province;
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