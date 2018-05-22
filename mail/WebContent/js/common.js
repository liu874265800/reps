// 通用模块
var com = new Object();

com.baseUrl = 'http://localhost:8080/mail/';

/**
 * 获取Cookie
 */
com.getCookie = function(name) {
	var cookies = document.cookie.split(';');
	var value;
	for (var i = 0; i < cookies.length; i++) {
		var cookie = cookies[i].split('=');
		if (cookie[0].trim() == name) {
			value = cookie[1];
			break;
		}
	}
	return value;
}

/**
 * 设置Cookie
 */
com.setCookie = function(name,value) {
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + value + ";expires=" + exp.toGMTString();
}

/**
 * 登录
 */
com.login = function() {
    $.ajax({
        type: "post",
        data: $("#login_form").serialize(),
        url: com.baseUrl + "home/userLoginServlet",
        success: function(result){
            var jsonResult = JSON.parse(result);
            if(jsonResult.status == 200){
            	var dialog = AMUI.dialog.alert({
        			title : '提示',
        			content: jsonResult.message+",3秒钟后跳转到首页..."
        		});
        		setTimeout(function() {
        			dialog.modal('close');
        			window.location.href=com.baseUrl + 'home/home.jsp';
        		}, 3000);	
            }else{
            	var dialog = AMUI.dialog.alert({
        			title : '提示',
        			content: jsonResult.message
        		});
        		setTimeout(function() {
        			dialog.modal('close');
        		}, 3000);
            }
         }
     });
}

/**
 * 绑定登录按钮事件
 */
com.bindLoginEvent = function() {
	$("#login_button").bind({click:function(){
		com.login();
	}});
	
	$("#userLogout").bind({click:function(){
		com.logout();
	}});
	
	// 绑定记住密码按钮事件
	$("#remember-me").bind({click:function(){
		$("#remember").val(this.checked);
	}});
}

/**
 * 获取页面验证码
 */
com.loadCode = function() {
    $.ajax({
        type: "get",
        url: com.baseUrl + "home/codeServlet?type=page",
        success: function(result){
            var jsonResult = JSON.parse(result); 
        	if(jsonResult.status == 200){
        		var data = jsonResult.data;
        		$("#codeImg")[0].src= data;
             }
         }
     });
}
/**
 * 注册
 */
com.register = function(formData) {
    $.ajax({
        type: "post",
        data: formData,
        url: com.baseUrl + "home/userRegisterServlet",
        success: function(result){
            var jsonResult = JSON.parse(result); 
         // 注册成功
    		var dialog = AMUI.dialog.alert({
    			title : '提示',
    			content: jsonResult.message+",3秒钟后跳转到登陆..."
    		});
    		setTimeout(function() {
    			dialog.modal('close');
    			window.location.href='login.jsp';
    		}, 3000);
         }
     });
}

/**
 * 注册页事件绑定
 */
com.bindRegisterEvent = function() {
	$("#emailRegister").bind({click:function(){
		var form = $(document.forms[0]).serialize();
		com.register(form);
	}});
	
	$("#phoneRegisger").bind({click:function(){
		var form = $(document.forms[1]).serialize();
		com.register(form);
	}});
	
	// 绑定实时验证事件(邮箱)
	$("#email").bind({blur:function(){
	    $.ajax({
	        type: "get",
	        url: com.baseUrl + "home/userRegisterServlet?email="+this.value,
	        success: function(result){
	            var jsonResult = JSON.parse(result); 
	        	if(jsonResult.status != 200){
	        		var dialog = AMUI.dialog.alert({
	        			title : '提示',
	        			content: jsonResult.message
	        		});
	        		setTimeout(function() {
	        			dialog.modal('close');
	        		}, 3000);
	             }
	         },
	         error: function(error) {
				// 加载验证码异常处理
			}
	     });
	}});
	
	
	// 绑定实时验证事件(手机)
	$("#phone").bind({blur:function(){
		// 页面加载获取验证码
	    $.ajax({
	        type: "get",
	        url: com.baseUrl + "home/userRegisterServlet?phone="+this.value,
	        success: function(result){
	            var jsonResult = JSON.parse(result); 
	        	if(jsonResult.status != 200){
	        		var dialog = AMUI.dialog.alert({
	        			title : '提示',
	        			content: jsonResult.message
	        		});
	        		setTimeout(function() {
	        			dialog.modal('close');
	        		}, 3000);
	             }
	         },
	         error: function(error) {
				// 加载验证码异常处理
			}
	     });
	}});
	
	$("#validateCode").bind({blur:function(){
		// 页面加载获取验证码
	    $.ajax({
	        type: "post",
	        url: com.baseUrl +"home/codeServlet?validateCode="+this.value,
	        success: function(result){
	            var jsonResult = JSON.parse(result); 
	        	if(jsonResult.status != 200){
	        		var dialog = AMUI.dialog.alert({
	        			title : '提示',
	        			content: jsonResult.message
	        		});
	        		setTimeout(function() {
	        			dialog.modal('close');
	        		}, 3000);
	             }
	         },
	         error: function(error) {
				// 加载验证码异常处理
			}
	     });
	}});
	
	$("#phoneValidateCode").bind({blur:function(){
		// 页面加载获取验证码
	    $.ajax({
	        type: "post",
	        url: com.baseUrl +"home/codeServlet?validateCode="+this.value,
	        success: function(result){
	            var jsonResult = JSON.parse(result); 
	        	if(jsonResult.status != 200){
	        		var dialog = AMUI.dialog.alert({
	        			title : '提示',
	        			content: jsonResult.message
	        		});
	        		setTimeout(function() {
	        			dialog.modal('close');
	        		}, 3000);
	             }
	         },
	         error: function(error) {
				// 加载验证码异常处理
			}
	     });
	}});
	
	
	// 获取手机验证码
	$("#sendMobileCode").bind({click:function(){
	    $.ajax({
	        type: "get",
	        url: com.baseUrl +"home/codeServlet?phone="+$("#phone").val()+"&type=mobile",
	        success: function(result){
	        	var jsonResult = JSON.parse(result);
	        	var dialog = AMUI.dialog.alert({
        			title : '提示',
        			content: jsonResult.message
        		});
        		setTimeout(function() {
        			dialog.modal('close');
        		}, 3000);
	         },
	         error: function(error) {
				// 加载验证码异常处理
			}
	     });
	}});
	
	// 点击验证码图片自动刷新验证码
	$("#codeImg").bind({click:function(){
		com.loadCode();
	}});
}
/**
 * 找回密码
 */
com.findPassword = function() {
    $.ajax({
        type: "get",
        url: com.baseUrl + "home/findPasswordServlet?email="+$("#email").val(),
        success: function(result){
            var jsonResult = JSON.parse(result); 
         // 注册成功
    		var dialog = AMUI.dialog.alert({
    			title : '提示',
    			content: jsonResult.message+",3秒钟后跳转到首页..."
    		});
    		setTimeout(function() {
    			dialog.modal('close');
    			window.location.href='home.jsp';
    		}, 3000);
         }
     });
}
/**
 * 绑定找回密码事件
 */
com.bindFindPasswordEvent = function() {
	$("#find_button").bind({click:function(){
		com.findPassword();
	}});
}
