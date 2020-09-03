var signup = {
		init : function () {
		    var _this = this;
		    $('#join-submit').on('click', function (e) {
		        _this.submit(e);
		    });
		},
		
		submit : function(e){
				e.preventDefault();
			
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
			
		        var email = $('#email').val();
		        var password = $("#password").val();
		        var passwordCheck = $("#passwordCheck").val();
		        
		        if(email == ''){
		            alert('이메일을 입력하세요');
		            $("#email").focus();
		            return false;
		        } else {
		            var emailRegex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		            if (!emailRegex.test(email)) {
		            	alert('이메일 양식에 맞게 입력해주세요. ex) abc@gmail.com');
		                $("#email").focus();
		                return false;
		            }
		        }

		        if(password ==''){
		            alert('비밀번호를 입력하세요');
		            $("#password").focus();
		            return false;
		        }

		        if(passwordCheck ==''){
		            alert('비밀번호를 다시 한번 더 입력하세요');
		            $("#passworkCheck").focus();
		            return false;
		        }
		        
		        if(password !== passwordCheck){
		            alert('비밀번호를 둘다 동일하게 입력하세요');
		            return false;
		        }
		        
		        if($("#agree").is(":checked") == false){
		            alert('약관에 동의하셔야 합니다');
		            return false;      
		        }
		        
		        var data = {
		    		email : email,
		        	password : password
		        }
		        
		        $.ajax({
		            url: '/user/signup',
		            type: 'POST',
		            contentType: 'application/json; charset=utf-8',
		            data: JSON.stringify(data),
		            dataType: "json",
		            beforeSend: function(xhr){
		    			xhr.setRequestHeader(header, token);
		    		},
		    		success : function(response) {
				    			if(response == 0){
				                	alert('이미 가입된 아이디입니다.');
				                }else {
				                	alert('가입 완료');
				                	location.href = "/";
				                }
				        },
			        error : function (error) {
		            	alert("arjax error : " + error);
		            }
            });
	    }
	}

signup.init();