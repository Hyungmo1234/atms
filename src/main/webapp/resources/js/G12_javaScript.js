$(function() { 
	
	$("#month_before").click( function(){
		var month_data = Number($("#month").val()) - 1;
		
		year_month_checkAndSubmit(month_data);
	});
	
	$("#month_next").click( function(){
		var month_data = Number($("#month").val()) + 1;
		
		year_month_checkAndSubmit(month_data);
	});	
	
	function year_month_checkAndSubmit( month_data ){
		var month = month_data;
		if(month < 1){
			var year_data = Number($("#year").val()) - 1;
			$("#year").val(year_data);
			$("#month").val(12);
			
		}else if(month > 12){
			var year_data = Number($("#year").val()) + 1;
			$("#year").val(year_data);
			$("#month").val(1);
		}else {
			$("#month").val(month_data);
		}
		
		$("#formTest").submit();
	}
	
	
	$("#calendar").click(function(){
		var win = window.open('/G07', '_blank', 'width=600 height=600');
		
		$(win).on('load', function(){
		   $(win).on('unload', function () {
		       $("#formTest").submit();
		   });
		});
	});
	
	
});