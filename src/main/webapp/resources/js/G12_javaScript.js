$(function() { 
	console.log(window);
	
	$("#month_mae").click( function(){
		alert("hello")
		//formTest	
	})
	
});	

function test(){
	var tt = window;
	tt.close = function test(){
		alert("close");
		console.log("Test:close");
	};
	tt.open('/G07', '_blank', 'width=600 height=600');
	console.log(tt);
}