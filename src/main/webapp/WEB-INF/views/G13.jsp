<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title></title>
        
        <!-- CSS --> 
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"                type="text/css" />
        <link rel="stylesheet" href="http://cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.css" type="text/css" />
        
        <style type="text/css">
            div#contentsDiv{
	            min-width  : 100% ;
	            min-height : 510px;
	            max-height : 510px;
	            
	            border : 1px solid red;
	            
	            margin-bottom : 1%;
	            
	            overflow : auto;
            }
            
            table.contentsTable{
              width  : 1000px;
              height :  490px;
              
              margin-top    : 10px;
              margin-bottom : 10px;
            }
            
            table.contentsTable tr td{
                width  : 50px;
                height : 30px;
                
                border-collapse : collapse;
            }
            
            table.contentsTable,
            table.contentsTable tr,
            table.contentsTable tr td{
                border-collapse : collapse;
            }
            
            table.vacationSchedule tr td{
                padding : 15px;
            }
            
            table.contentsTable tr.rowWorkTimeController td{
                text-align : center;
            }
        </style>
        
        <!-- API Load -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"         ></script>  
        <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"                       ></script>  
        <script src='http://cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.js'></script>
        
        <!-- JavaScript -->
        <script type="text/javascript">
            $(document).ready(function(){
            	var result = new Array();
            	
            	<c:forEach items="${t_vacation_management}" var="t_vacation_management">
            	    var obj = new Object();
            	    
        		    obj.id            = "${t_vacation_management.id           }";
                    obj.yearmonth     = "${t_vacation_management.yearmonth    }";
                    obj.index         = "${t_vacation_management.index        }";
        	        obj.vac_startdate = "${t_vacation_management.vac_startdate}";
        	        obj.vac_enddate   = "${t_vacation_management.vac_enddate  }";
        	        obj.division      = "${t_vacation_management.division     }";
        	        obj.detail        = "${t_vacation_management.detail       }";
            	    
            	    result.push(obj);
            	</c:forEach>
            	
            	for(var i = 0; i < result.length; ++i) {
					plusSchedule();

					$(".testDatepicker1").eq(i).val(result[i].vac_startdate);
					$(".testDatepicker2").eq(i).val(result[i].vac_enddate  );
					$(".scheduleTime"   ).eq(i).val(result[i].division     );
					$(".scheduleDetail" ).eq(i).val(result[i].detail       );
				}
            	
            	result = new Array();
            	
            	<c:forEach items="${t_vacation_holiday}" var="t_vacation_holiday">
            	    var obj = new Object();
            	    
        		    obj.id            = "${t_vacation_holiday.id       }";
                    obj.yearmonth     = "${t_vacation_holiday.yearmonth}";
                    obj.index         = "${t_vacation_holiday.index    }";
                    obj.holi_work     = "${t_vacation_holiday.holi_work}";
            	    
            	    result.push(obj);
            	</c:forEach>
            	
            	for(var i = 0; i < result.length; ++i) {
					plusWeekendWork();
					
					$(".testDatepicker3:eq(" + i + ")").val(result[i].holi_work);
				}
            	
            	result = new Array();

            	<c:forEach items="${t_vacation_worktimecontrol}" var="t_vacation_worktimecontrol">
            	    var obj = new Object();
            	    
        		    obj.id            = "${t_vacation_worktimecontrol.id       }";
                    obj.yearmonth     = "${t_vacation_worktimecontrol.yearmonth}";
                    obj.index         = "${t_vacation_worktimecontrol.index    }";
                    obj.con_time      = "${t_vacation_worktimecontrol.con_time }";
            	    
            	    result.push(obj);
            	</c:forEach>
            	
            	for(var i = 0; i < result.length; ++i) {
					plusWorkController();
					
					var con_time = (result[i].con_time).split(" ");
					
					var con_time_1 = con_time[0].replace(/-/gi, "");
					var con_time_2 = con_time[1].substring(0, 5);
					
					$(".testDatepicker4:eq(" + i + ")").val(con_time_1);
					$(".testTimepicker1:eq(" + i + ")").val(con_time_2);
				}
            	
            	$("#saveButton").click(function(){
            		var vacationSchedule = new Array();
            		
            		var vac_startdate = $(".testDatepicker1");
            		var vac_enddate   = $(".testDatepicker2");
            		var division      = $(".scheduleTime"   );
            		var detail        = $(".scheduleDetail" );
            		var holi_work     = $(".testDatepicker3");
            		var con_time_1    = $(".testDatepicker4");
            		var con_time_2    = $(".testTimepicker1");
            		
            		var loopLength = [vac_startdate.length, holi_work.length, con_time_1.length];
            		
            		var yearmonth = new Date().getFullYear() + new Date().getMonth() + 1;
            		
            		for(var i = 0; i < Math.max.apply(null, loopLength) - 1; i++) {
            			var obj = new Object();
            			
            			var tempCon_time_2 = (con_time_2.eq(i).val()).replace(":", "") + "00";
            			
            			obj.yearmonth     = yearmonth                                                                                   ;
            			obj.vac_startdate = ((vac_startdate.eq(i).val() != undefined) ? vac_startdate.eq(i).val()                  : "");
            		    obj.vac_enddate   = ((vac_enddate  .eq(i).val() != undefined) ? vac_enddate  .eq(i).val()                  : "");
            		    obj.division      = ((division     .eq(i).val() != undefined) ? division     .eq(i).val()                  : "");
            		    obj.detail        = ((detail       .eq(i).val() != undefined) ? detail       .eq(i).val()                  : "");
            		    obj.holi_work     = ((holi_work    .eq(i).val() != undefined) ? holi_work    .eq(i).val()                  : "");
            		    obj.con_time      = ((con_time_1   .eq(i).val() != undefined) ? con_time_1   .eq(i).val() + tempCon_time_2 : "");
            		    
						vacationSchedule.push(obj);
					}
            		
            		$.ajax({
            	        url      : "/atms/G13_1"  ,
            	        type     : "GET"          ,
            	        data     : {"vacationSchedule" : JSON.stringify(vacationSchedule)},
            	        success  : function(data) {
            	        	alert(data.result);
            	        },
            	        error    : function(xhr, status, error) {
            	            alert(error);
            	        }
            	    });
            	});
            	
            	$("#printButton").click(function(){
            		alert("phase3");
            	});
            	
            	$("#cancelButton").click(function(){
            		
            	});
        	});
            
            function plusSchedule(){
                var rowData = $("#plusScheduleRow").children("table").children("tbody").html();
            	
                var rowScheduleCnt = $(".rowSchedule").length - 1;
                
                if(rowScheduleCnt < 5){
            	    $("#vacationSchedule #plusSchedule").detach();
            	    
            	    $("#vacationSchedule").append(rowData);
            	    
            	    $(document).find("#vacationSchedule .testDatepicker1").removeClass('hasDatepicker').datepicker({dateFormat : "yymmdd"});     
            	    $(document).find("#vacationSchedule .testDatepicker2").removeClass('hasDatepicker').datepicker({dateFormat : "yymmdd"});     
                }
                else{
                    alert("最大５行まで入力でします。");	
                }
            }
            
            function minusSchedule(element){
            	var idx            = $(".minusSchedule").index(element);
            	var rowScheduleCnt = $(".rowSchedule"  ).length - 1    ;
            	
            	if(rowScheduleCnt > 1){
            	    if(rowScheduleCnt == (idx + 1)){
            	    	var html = "<div id='plusSchedule' style='margin : auto; cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;' onclick='plusSchedule();'>+</div>";
            	    	
            	    	$(".rowSchedule:eq(" + (idx - 1) + ")").children("td:eq(0)").append(html);
            	    }
            	    
            	    $(".rowSchedule:eq(" + idx + ")").detach();
            	}
            	else{
            		alert("すべての行の削除はできません。");
            	}
            }
            
            function plusWeekendWork(){
                var rowData = $("#plusWeekendWorkRow").children("table").children("tbody").html();
                
                var rowWeekendWorkCnt = $(".rowWeekendWork").length - 1;
                
                if(rowWeekendWorkCnt < 5){
                    $("#weekendWork #plusWeekendWork").detach();
            	
            	    $("#weekendWork").append(rowData);
            	    
            	    $(document).find("#weekendWork .testDatepicker3").removeClass('hasDatepicker').datepicker({dateFormat : "yymmdd"});
                }
                else{
                    alert("最大５行まで入力でします。");	
                }
            }

            function minusWeekendWork(element){
            	var idx               = $(".minusWeekendWork").index(element);
            	var rowWeekendWorkCnt = $(".rowWeekendWork"  ).length - 1    ;
            	
            	if(rowWeekendWorkCnt > 1){
            	    if(rowWeekendWorkCnt == (idx + 1)){
            	    	var html = "<div id='plusWeekendWork' style='margin : auto; cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;' onclick='plusWeekendWork();'>+</div>";
            	    	
            	    	$(".rowWeekendWork:eq(" + (idx - 1) + ")").children("td:eq(0)").append(html);
            	    }
            	    
            	    $(".rowWeekendWork:eq(" + idx + ")").detach();
            	}
            	else{
            		alert("すべての行の削除はできません。");
            	}
            }
            
            function plusWorkController(){
                var rowData = $("#plusWorkControllerRow").children("table").children("tbody").html();
            	
                var rowWorkControllerCnt = $(".rowWorkController").length - 1;
                
                if(rowWorkControllerCnt < 5){
                    $("#workController #plusWorkController").detach();
            	
            	    $("#workController").append(rowData);
            	    
            	    $(document).find("#WorkController .testDatepicker4").removeClass('hasDatepicker').datepicker({dateFormat : "yymmdd"  });
            	    $(document).find("#WorkController .testTimepicker1").removeClass('hasTimepicker').timepicker({                       });
                }
                else{
                    alert("最大５行まで入力でします。");	
                }
            }

            function minusWorkController(element){
            	var idx                  = $(".minusWorkController").index(element);
            	var rowWorkControllerCnt = $(".rowWorkController"  ).length - 1    ;
            	
            	if(rowWorkControllerCnt > 1){
            	    if(rowWorkControllerCnt == (idx + 1)){
            	    	var html = "<div id='plusWorkController' style='margin : auto; cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;' onclick='plusWorkController();'>+</div>";
            	    	
            	    	$(".rowWorkController:eq(" + (idx - 1) + ")").children("td:eq(0)").append(html);
            	    }
            	    
            	    $(".rowWorkController:eq(" + idx + ")").detach();
            	}
            	else{
            		alert("すべての行の削除はできません。");
            	}
            }
        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/common/header.jsp"></jsp:include>
    
        <!-- START contentsDiv -->
        <div id="contentsDiv">
            <!-- START contentsTable -->
            <table class="contentsTable" border="1" align="center">
                <tr>
                    <td colspan="4" style="padding-left : 15px;">休暇</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div style="min-height : 200px; max-height : 200px; overflow : auto;">
                            <!-- START vacationSchedule -->
                            <table id="vacationSchedule" class="vacationSchedule" align="center"></table>
                            <!-- END vacationSchedule -->
                        </div>
                    </td>
                </tr>
                <tr class="rowWorkTimeController">
                    <td rowspan="2" style="width : 30px; height : 120px; ">休<br>日<br>出<br>勤</td>
                    <td rowspan="2" style="width : 470px; vertical-align : top;">
                        <div style="min-height : 134px; max-height : 134px; padding-top : 10px; overflow : auto;">
                            <!-- START weekendWork -->
                            <table id="weekendWork" class="weekendWork" align="center"></table>
                            <!-- END vacationSchedule -->
                        </div>
                    </td>
                    <td rowspan="2" style="width : 30px; width : 120px;">出<br>勤<br>時<br>間<br>調<br>整</td>
                    <td style="height : 120px; width : 470px">
                        <div style="min-height : 120px; max-height : 120px; padding-top : 10px; overflow : auto;">
                            <!-- START workController -->
                            <table id="workController" class="workController" align="center"></table>
                            <!-- END workController -->
                        </div>
                    </td>
                </tr>
                <tr>
                    <td style="font-size : 10pt; text-align : center; padding: 0px;">※現場都合で出勤時間の変更があった場合のみ</td>
                </tr>
                <tr>
                    <td colspan="1" style="text-align : center; font-size : 10pt; height : 45px; width : 120px;">現場基準時間</td>
                    <td colspan="3"></td>                                                  
                </tr>                                                                      
                <tr>                                                                       
                    <td colspan="1" style="text-align : center; font-size : 10pt; height : 45px;">現   場</td>
                    <td colspan="3"></td>                                                  
                </tr>                                                                      
                <tr>                                                                       
                    <td colspan="1" style="text-align : center; font-size : 10pt; height : 45px;">現場リーダー</td>
                    <td colspan="3"></td>                                                
                </tr>                                                                    
                <tr>                                                                     
                    <td colspan="1" style="text-align : center; font-size : 10pt; height : 45px;">緊急連絡先<br>(日本）</td>
                    <td colspan="3"></td>                                                  
                </tr>                                                                      
                <tr>                                                                       
                    <td colspan="1" style="text-align : center; font-size : 10pt; height : 45px;">緊急連絡先<br>(日本外）</td>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="1" style="text-align : center; font-size : 10pt; height : 45px;">ビザの有効期限</td>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4" style="text-align : right;">
                        <input type="button" id="saveButton"  style="border : 0px; border-radius : 3px; background-color : rgb(195, 195, 195); width : 80px; height :30px;" value="保存"　/>
                        <input type="button" id="printButton" style="border : 0px; border-radius : 3px; background-color : rgb(195, 195, 195); width : 80px; height :30px;" value="出力"　/>
                    </td>
                </tr>
            </table>
            <!-- END contentsTable -->
            
            <input type="button" id="cancelButton" style="margin : 10px; border : 0px; border-radius : 3px; background-color : rgb(195, 195, 195); width : 80px; height :30px;" value="戻る"　/>
        </div>
        <!-- END contentsDiv -->
    
        <div id="plusScheduleRow" style="display : none;">
            <table>
                <tr class="rowSchedule">
                    <td style="text-align : center;">
                        <div id="plusSchedule" style="cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;" onclick="plusSchedule();">+</div>
                    </td>
                    <td>
                        <input type="text" class="testDatepicker1" readonly style="width : 200px; text-align : center;"/>
                    </td>
                    <td>
                        <input type="text" class="testDatepicker2" readonly style="width : 200px; text-align : center;"/>
                    </td>
                    <td>
                        <select class="scheduleTime" style="width : 200px;">
                            <option value="0">選んでください。</option>
                            <option value="1">午前休</option>
                            <option value="2">午後休</option>
                        </select>
                    </td>
                    <td style="text-align : center; width : 200px;">
                        <input class="scheduleDetail" type="text" />
                    </td>
                    <td>
                        <div class="minusSchedule" style="cursor:pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;" onclick="minusSchedule(this);">-</div>
                    </td>
                </tr>
            </table>
        </div>
    
        <div id="plusWeekendWorkRow" style="display : none;">
            <table>
                <tr class="rowWeekendWork">
                    <td>
                        <div id="plusWeekendWork" style="margin : auto; cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;" onclick="plusWeekendWork();">+</div>
                    </td>
                    <td>
                        <input type="text" class="testDatepicker3" readonly style="width : 170px; text-align : center;"/>
                    </td>
                    <td style="text-align : center; width : 170px;">
                        <label>月</label>
                    </td>
                    <td>
                        <div class="minusWeekendWork" style="margin : auto; cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;" onclick="minusWeekendWork(this);">-</div>
                    </td>
                </tr>
            </table>
        </div>
        
        <div id="plusWorkControllerRow" style="display : none;">
            <table>
                <tr class="rowWorkController">
                    <td>
                        <div id="plusWorkController" style="margin : auto; cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;" onclick="plusWorkController();">+</div>
                    </td>
                    <td>
                        <input type="text" class="testDatepicker4" readonly style="width : 170px; text-align : center;" />
                    </td>
                    <td style="text-align : center; width : 170px;">
                        <input type="text" class="testTimepicker1" readonly style="width : 170px; text-align : center;" />
                    </td>
                    <td>
                        <div class="minusWorkController" style="margin : auto; cursor : pointer; border : 1px solid black; border-radius : 10px; width : 20px; height : 20px; text-align : center;" onclick="minusWorkController(this);">-</div>
                    </td>
                </tr>
            </table>
        </div>
    
        <jsp:include page="/WEB-INF/common/footer.jsp"></jsp:include>
    </body>
</html>