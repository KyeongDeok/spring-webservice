var update = {
    init : function () {
        var _this = this;
        $('#btn-update').on('click', function () {
            _this.update();
        });
    },
    update : function () {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		 
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/api/posts/'+$('#pageId').val(),
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
            beforeSend: function(xhr){
    			xhr.setRequestHeader(header, token);
    		}
        }).done(function() {
            alert('글이 수정되었습니다.');
            location.href = "/";
        }).fail(function (error) {
            alert(error);
        });
    }
};

var deletePost = {
		 init : function () {
		        var _this = this;
		        $('#btn-delete').on('click', function () {
		            _this.del();
		        });
		    },
	     del : function () {
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");

		        $.ajax({
		            type: 'DELETE',
		            url: '/api/posts/'+$('#pageId').val(),
		            beforeSend: function(xhr){
		    			xhr.setRequestHeader(header, token);
		    		}
		        }).done(function() {
		            alert('글이 삭제되었습니다.');
		        }).fail(function (error) {
		            alert(error);
		        });
		    }
}

deletePost.init();
//update.init();