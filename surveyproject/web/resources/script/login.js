
$.fn.bindLogin = function() {
		
	this.click(function(){
		if($('#email').val().trim() == '') {
			alert('이메일을 입력하세요.');
			$('#email').val('').focus();
			return;
		}
		
		if($('#pass').val().trim() == '') {
			alert('비밀번호를 입력하세요.');
			$('#pass').val('').focus();
			return;
		}
				
		$.ajax({
			url: '/login',
			type: 'post',
			data: {
				email: $('#email').val(),
				password: $('#pass').val()
			},
			success: function(data) {
				alert(data.message);
				switch(data.errno) {
					case "2":
						location.href = 'report.jsp';
						break;

					default:
						location.reload();
						break;
				}
			}
		});
	});	
}

$.fn.bindEnterPress = function() {
	this.keypress(function(e) {
		if (e.keyCode == 13) {
			$('.login #signIn').trigger('click');
		}
	});
}

$(document).ready(function(){
	$('div.login button#signUp').click(function(){
		location.href='signUp.jsp';
	});
	
	$('.login #findPass').click(function(){
		$('.mid > #side > #changePass').css('display', 'block');
	})
	
	$('.login #email').bindEnterPress();
	$('.login #pass').bindEnterPress();
	
})

