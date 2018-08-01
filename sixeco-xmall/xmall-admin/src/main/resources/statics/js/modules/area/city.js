$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'city/page',
        datatype: "json",
        colModel: [			
			{ label: 'cityId', name: 'cityId', index: 'city_id', width: 50, key: true },
			{ label: '省份ID', name: 'provinceId', index: 'province_id', width: 80 }, 			
			{ label: '城市名称', name: 'cityName', index: 'city_name', width: 80 }, 			
			{ label: '邮政编码', name: 'zipCode', index: 'zip_code', width: 80 }			
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
		city: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.city = {};
		},
		update: function (event) {
			var cityId = getSelectedRow();
			if(cityId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(cityId)
		},
		saveOrUpdate: function (event) {
			var url = vm.city.cityId == null ? "city/save/json" : "city/update/json";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.city),
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
			var cityIds = getSelectedRows();
			if(cityIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "city/delete",
                    contentType: "application/json",
				    data: JSON.stringify(cityIds),
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
		getInfo: function(cityId){
			$.get(baseURL + "city/info/"+cityId, function(r){
                vm.city = r.city;
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