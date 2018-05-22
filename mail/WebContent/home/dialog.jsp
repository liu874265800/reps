<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>弹出对话框</title>
<link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="jquery-ui/jquery-ui.min.js"></script>
<script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
<script src="../AmazeUI-2.4.2/assets/js/amazeui.dialog.js"></script>

<script type="text/javascript">

function alert(){
	AMUI.dialog.alert({
		title : '提示框',
		content : '你的家还好吧',
		onConfirm : function() {
			console.log('close');
		}
		});
}

function confirm(){
	AMUI.dialog.confirm({
		title : '确认框',
		content : '正文内容',
		onConfirm : function() {
			console.log('onConfirm');
		},
		onCancel : function() {
			console.log('onCancel')
		}
		});
}

/**
 * 加载进度条
 */
function loading(){
	var $loading = AMUI.dialog.loading();
	setTimeout(function() {
	$loading.modal('close');
	}, 3000);
}

/**
 * 动作面板
 */
function action(){
	var $actions = AMUI.dialog.actions({
		title : '动作面板',
		items : [ {
			content : '<a href="#"><span class="am-icon-wechat"></span> 分享到微信</a>'
		}, {
			content : '<a href="#"><i class="am-icon-mobile"></i> 短信分享</a>'
		}, {
			content : '<a href="#"><i class="am-icon-twitter"></i> 分享到 XX 萎跛</a>'
		} ],
		onSelected : function(index, target) {
			console.log(index);
			$actions.close();
		}
		});

		$actions.show();
		AMUI.dialog.popup({
		title : '标题',
		content : '正文'
		});
}

</script>
</head>
<body>
<center>
	<button onclick="alert()">提示框</button>
	<button onclick="confirm()">确认框</button>
	<button onclick="loading()">加载框</button>
	<button onclick="action()">动作面板</button>
</center>
</body>
</html>