$(document).ready(function() {
	
	var sortRules=0;
	$("input[type=file]").on('change',function(){
		var isValidRule=validateRules();
		if(isValidRule){
			sortRules=mappingRules();
			if(this.files.length>0)
				$( "#formSort" ).submit();		
		}			
		if(!isValidRule)
			$(this).val("");		
	});
	
	$("#formSort").submit( function( e ) {  
		var data =new FormData();
		data.append( "fUpload", $( '#fUpload' )[0].files[0] );
		data.append("Author", $('#chkAuthor').is(':checked'));
		data.append("Title", $('#chkTitle').is(':checked'));
		data.append("Edition", $('#chkEdition').is(':checked'));
		data.append("OrderAuthor", $('#rdoAscending1').is(':checked'));
		data.append("OrderTitle", $('#rdoAscending2').is(':checked'));
		data.append("OrderEdition", $('#rdoAscending3').is(':checked'));
		data.append("AttributesOrder", sortRules);
	    
		$.ajax( {
	      url: 'SortServlet',
	      type: 'POST',
	      data:data,
	      processData: false,
	      contentType: false,
	      success: function(data){
	    	  try {
	              var obj = JSON.parse(data);
	              if(obj.status){
	            	  $('#sortResult').text(obj.result);
	              }
	              else
	            	  throw new Error("Cannot to sort! Error: "+obj.result);
	            } catch(e) {
	              alert(e.message);
	            }
	            $('#fUpload').val("");
	      },
		  error:function(data,status,er){
				alert("error: "+data+" status: "+status+" er:"+er);
				$('#fUpload').val("");
		  },
	      beforeSend: function(args){
	      }      
	    });
	    e.preventDefault();
	 });
	
	 $("#rdoAscending1").change(function(){
		 if ($(this).is(':checked'))
			 $("#rdoDescending1").prop("checked", false);
	 });
	 $("#rdoDescending1").change(function(){
		 if ($(this).is(':checked'))
			 $("#rdoAscending1").prop("checked", false);
	 });
	 $("#rdoAscending2").change(function(){
		 if ($(this).is(':checked'))
			 $("#rdoDescending2").prop("checked", false);
	 });
	 $("#rdoDescending2").change(function(){
		 if ($(this).is(':checked'))
			 $("#rdoAscending2").prop("checked", false);
	 });
	 $("#rdoAscending3").change(function(){
		 if ($(this).is(':checked'))
			 $("#rdoDescending3").prop("checked", false);
	 });
	 $("#rdoDescending3").change(function(){
		 if ($(this).is(':checked'))
			 $("#rdoAscending3").prop("checked", false);
	 });
	 
	 
	 function checkOptionSort(){
		 var isAuthor=$('#chkAuthor').is(':checked');
		 var isTitle=$('#chkTitle').is(':checked');
		 var isEdition=$('#chkEdition').is(':checked');	 
		 var optionAtrrib=0;
		 
		 if(!isAuthor && !isTitle && !isEdition) optionAtrrib=10;
		 else if(isAuthor && !isTitle && !isEdition) optionAtrrib=0;
			  else if(isAuthor && isTitle && !isEdition) optionAtrrib=1;
		 	  	   else if(isAuthor && !isTitle && isEdition) optionAtrrib=2;
		 	  	   		else if(isAuthor && isTitle && isEdition) optionAtrrib=3;
		 	  	   			 else if(!isAuthor && isTitle && !isEdition) optionAtrrib=4;
		 	  	   			 	   else if(!isAuthor && isTitle && isEdition) optionAtrrib=5;
		 	  	   			 	   		else optionAtrrib=6;
		 	 
		return optionAtrrib;
	 }
	 
	 function checkPrioriSort(){
		 var priorAuthor= parseInt($('#selAuthorPriori option:selected').val());
		 var priorTitle= parseInt($('#selTitlePriori option:selected').val());
		 var priorEdition= parseInt($('#selEditionPriori option:selected').val());
		 var option=checkOptionSort();
		 
		 switch(option){
		 	case 1: return (priorAuthor != priorTitle) && (priorAuthor<3 && priorTitle<3) ? '{"status":true,"message":"Priorite Ok!"}'  :  '{"status":false,"message":"The priorites must be differents and lower 3!"}';
		 	case 2: return (priorAuthor != priorEdition) && (priorAuthor<3 && priorEdition<3) ?  '{"status":true,"message":"Priorite Ok!"}'  :  '{"status":false,"message":"The priorites must be differents and lower 3!"}';
		 	case 3: return (priorAuthor != priorTitle) && (priorAuthor != priorEdition) && (priorTitle != priorEdition) ?  '{"status":true,"message":"Priorite Ok!"}'  :  '{"status":false,"message":"The priorites must be differents and lower 3!"}';
		 	case 5: return (priorTitle != priorEdition) && (priorTitle<3 && priorEdition<3) ?  '{"status":true,"message":"Priorite Ok!"}'  :  '{"status":false,"message":"The priorites must be differents and lower 3!"}';
		 	case 10: return '{"status":true,"message":"There is no attributes selected!"}';
		 	default:return (priorTitle!=1 || priorTitle!=1 || priorEdition!=1) ?  '{"status":false,"message":"The priorites should be 1 for these settings!"}'  :  '{"status":true,"message":"Priorites Ok!"}';
		 }		 
		 
	 }
	 
	 function validateRules(){
		 var result = JSON.parse(checkPrioriSort());
		 if(result.status)
			 return true;
		 else{
			 alert(result.message);
			 return false;
		 }		 
	 }
	 
	 function mappingRules(){
		 var priorAuthor= parseInt($('#selAuthorPriori option:selected').val());
		 var priorTitle= parseInt($('#selTitlePriori option:selected').val());
		 var priorEdition= parseInt($('#selEditionPriori option:selected').val());
		 var option=checkOptionSort();
		 
		 switch(option){
		 	case 0: return 0;
			case 1: return (priorAuthor < priorTitle) ? 3 : 5;
			case 2:	return (priorAuthor < priorEdition) ? 4: 7;
		 	case 3: return (priorAuthor < priorTitle) && (priorTitle < priorEdition) ? 9 : 
					( (priorAuthor < priorEdition) && (priorTitle > priorEdition) ? 10:
					( (priorAuthor > priorTitle) && (priorAuthor < priorEdition) ? 11 : 
					( (priorEdition > priorTitle) && (priorAuthor > priorEdition) ? 12: 
					( (priorAuthor > priorEdition) && (priorAuthor < priorTitle) ? 13 : 14 ))));	
		 	case 4: return  1;
			case 5: return (priorTitle < priorEdition) ? 6 : 8;
		 	case 6: return 2;
		 	default: return (-1);
		 }		 
	 }

});