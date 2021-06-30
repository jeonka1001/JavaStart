$.fn.bindRedirectSiteInfo = function(){
	$(this).on('click', (function(){
		location.href = '/siteInfo';
		})
	)
}

$.fn.bindRedirectSiteRule = function(){
	$(this).on('click', (function(){
		location.href = '/siteRule';
		})
	)
}

$.fn.bindWriteSurvey = function(){
	$(this).on('click', function(){
		// write code
	})
}

$.fn.bindParticipateSurvey = function(){
	$(this).on('click', function(){
		// ..write code
	})
}

$.fn.bindViewEndedSurvey = function(){
	$(this).on('click', function(){
		$.ajax({
			url:'../MemberLoginCheck.do',
			type:'get',
			success:funct2ion(data){
				if(data.result){
					location.href = 'closeSurvey.jsp';
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

$(document).ready(function(){
	$('#viewSiteInfo').bindRedirectSiteInfo();
	$('#viewSiteRule').bindRedirectSiteRule();
	$('#writeSurvey').bindWriteSurvey();
	
	$('#participateSurvey').bindParticipateSurvey();
	
	$('#viewEndedSurvey').bindViewEndedSurvey();
})