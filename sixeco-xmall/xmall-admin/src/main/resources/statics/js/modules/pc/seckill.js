$(function () {
	
	$("#search_state").selectpicker({  
	    noneSelectedText : '请选择状态'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	
	
    $("#jqGrid").jqGrid({
        url: baseURL + '/seckill/page?type='+type,
        datatype: "json",
        colModel: [
        	{ label: 'id', name: 'id', width: 80, key: true, hidden: true },
			{ label: '活动名称', name: 'activityName', width: 80 }, 			
			{ label: '开始时间', name: 'beginTime', width: 80 }, 			
			{ label: '结束时间', name: 'endTime', width: 80 }, 			
			{ label: '提示语', name: 'describes', width: 80 }, 			
			/*{ label: '活动状态', name: 'state', width: 80, formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '未开始';
	            }
	            if(cellvalue == 1){
	                return '进行中';
	            } 
	            if(cellvalue == 2){
	                return '已结束';
	            } 
	            return '未开始';
	        }},*/ 							 			
			{ label: '创建时间', name: 'createTime', width: 80 }, 			
			{ label: '开始时间点', name: 'beginTimePoint', width: 80 },			
			{ label: '结束时间点', name: 'endTimePoint',  width: 80 },
			{ label: '操作', name: '',  width: 80 },
			{ label: '上架', name: 'state', width: 120 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">下架</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">上架</span>';
	            } 
	            if(cellvalue == 2){
	                return '<span class="label label-primary">下架</span>';
	            } 
	            return '<span class="label label-primary">下架</span>';
	           
	        }}, 
			
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

console.log(type)
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		seckill: {},
		search: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.seckill = {
					type : type
			};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.seckill.id == null ? "/seckill/save/json" : "/seckill/update/json";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.seckill),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "/seckill/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get(baseURL + "/seckill/info/"+id, function(r){
                vm.seckill = r.seckill;
            });
		},
		shelve1: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			confirm('确定要上架吗', function(){
			        	$.ajax({
							type: "POST",
						    url: baseURL + "/seckill/updateShelve",
 						    data: {state:1,id:id,type:type},
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										vm.reload();
									});
								}else{
									alert(r.msg, function(data){
										vm.reload();
 									});
								} 
							}
						});
			});  
		},
		 	 
		shelve2: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			confirm('确定要下架吗', function(){
			        	$.ajax({
							type: "POST",
						    url: baseURL + "/seckill/updateShelve",
 						    data: {state:2,id:id,type:type},
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										vm.reload();
									});
								}else{
									alert(r.msg, function(data){
										vm.reload();
 									});
								} 
							}
						});
			});  
			 
		},
		query: function () {
			vm.search.state =$('#search_state').selectpicker('val');
			vm.search.type = type;
			vm.reload();
		},
		reload: function (event) {
			console.log(type)
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
				 postData:vm.search,
                page:page
            }).trigger("reloadGrid");
		}
	}
});