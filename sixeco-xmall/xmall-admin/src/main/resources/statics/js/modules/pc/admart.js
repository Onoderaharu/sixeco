$(function () {
	 /** 下拉框改变事件*/
	 $("#province").change(function(){
		 citySelected();
	 });
	 var prov={}  //省份
	 var city={}   //城市
	 
	 function formatCity(){
		 $.ajax({
			 async: false,
		     type: "get",
		     url: baseURL+"city/list",
		     success:function(res){
		    	 var pre=res.data;
		    	 for(var i=0;i<pre.length;i++){   		 
		    		 city['city_'+pre[i].cityId]=pre[i];
		    	 }
		    	 console.log(city);
		     }
		 });
	 }
	 formatCity();
	 
	 function formatProv(){
		 $.ajax({
			 async: false,
		     type: "get",
		     url: baseURL+"province/list",
		     success:function(res){
		    	 var pre=res.data;
		    	 for(var i=0;i<pre.length;i++){
		    		 prov['province_'+pre[i].provinceId]=pre[i];
		    	 }
		     }
		 });
	 }
	formatProv();
    $("#jqGrid").jqGrid({
    	url:baseURL+'admart/page',
        datatype: "json",
        colModel: [			
			/*{ label: 'martId', name: 'martId', index: 'mart_id', width: 50, key: true },
			{ label: '店铺关键字', name: 'keyword', index: 'keyword', width: 80 }, 		
			{ label: '品牌log', name: 'log', index: 'log', width: 80 }, 			
			{ label: '是否自营 0：否 1：自营', name: 'self', index: 'self', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '修改人', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '最后一次修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '用户id', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '商户类型 1:个人商户 2：个体户，企业用户', name: 'type', index: 'type', width: 80 }, 	
			{ label: '状态 0:审核中 1:审核通过 2:审核拒绝', name: 'status', index: 'status', width: 80 }, 	
			{ label: '身份证照片', name: 'idCardImg', index: 'id_card_img', width: 80 }, 		
			{ label: '营业执照号', name: 'licenseNo', index: 'license_no', width: 80 }, 			
			{ label: '营业执照图片', name: 'licenseImg', index: 'license_img', width: 80 }, */	
        	{ label: '店铺名称', name: 'martName', index: 'mart_name', width: 80 }, 			
			{ label: '真实姓名', name: 'realName', index: 'real_name', width: 80 }, 			
			{ label: '联系方式', name: 'contact', index: 'contact', width: 80 }, 			
			{ label: '总资产', name: 'totalAssets', index: 'total_assets', width: 80 },
			{ label: '省份', name: 'provinceId', index: 'province_id' ,width:80,formatter: function(cellvalue, options, rowObject){
					 var province=prov['province_'+cellvalue];
					 return '<span class="label label-primary">'+province.provinceName+'</span>';
				}
			},
			{ label: '城市' ,name: 'cityId' ,index: 'city_id' ,width:80,formatter: function(cellvalue,options,rowObject){
				    var cityObj=city['city_'+cellvalue];
				    return '<span class="label label-primary">'+cityObj.cityName+'</span>';
			   }
			}
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
		admart: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.admart = {};
		},
		update: function (event) {
			var martId = getSelectedRow();
			if(martId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(martId)
		},
		saveOrUpdate: function (event) {
			var url = vm.admart.martId == null ? "pc/admart/save" : "pc/admart/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.admart),
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
			var martIds = getSelectedRows();
			if(martIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pc/admart/delete",
                    contentType: "application/json",
				    data: JSON.stringify(martIds),
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
		getInfo: function(martId){
			$.get(baseURL + "pc/admart/info/"+martId, function(r){
                vm.admart = r.admart;
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

function provinceSelected(){ //如果需要标题可以传入title即(initSelected(sid,title))
	  $.ajax({
	        async: false,
	        type: "get",
	        url: baseURL+"province/list",  
	        success: function (res) {
			 for(var i=0; i<res.data.length; i++){
				    var provinceId=res.data[i].provinceId;
					var option="<option value=\""+res.data[i].provinceId+"\""; //res.data[i].keyword代表value=值 主键
				    option += ">"+res.data[i].provinceName+"</option>"; //动态添加数据
					$("#province").append(option);
				}
	        }
	    });
}
provinceSelected();

function citySelected(){
	 var provinceId = $("#province").val();
	 /*console.log("省："+provinceId);*/
	 $.ajax({
		 async:false,
		 type:'get',
		 dataType:'JSON',
		 url:baseURL+'city/cityInfo/'+provinceId,
		 success:function(data){	 
			 /*console.log(data);*/
			 $("#cityList").empty();
			 for(var i=0; i<data.city.length; i++){
				 	var city = data.city[i].cityId;
					var option="<option value=\""+data.city[i].cityId+"\"";
				    option += ">"+data.city[i].cityName+"</option>"; //动态添加数据
					$("#cityList").append(option);
	        } 
		 }
	 });
}