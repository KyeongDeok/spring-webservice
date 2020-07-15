var deletePost = {
	 init : function () {
	        var _this = this;
	        $('#btn-delete').on('click', function (e) {
	            _this.del(e);
	        });
	    },
     del : function (e) {
    	 e.preventDefault();
    	 
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		$.ajax({
            type: 'DELETE',
            url: '/api/posts/'+$("#postId").text(),
            beforeSend: function(xhr){
    			xhr.setRequestHeader(header, token);
    		}
	        }).done(function() {
	            alert('글이 삭제되었습니다.');
	            location.href = "/";
	            
	        }).fail(function (error) {
	            alert(error);
	        });
     	}
};

deletePost.init();