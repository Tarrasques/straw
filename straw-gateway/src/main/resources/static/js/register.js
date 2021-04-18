let registerApp = new Vue({
    el: '#registerApp',
    methods:{
        register:function (){
            $.ajax({
                url: '/api-user/v1/user/reg',
                data: $('#from-reg').serialize(),
                type: 'POST',
                success: function (json) {
                    if (json.state=2000){
                        alert('注册成功！')
                    }else {
                        alert(json.message)
                    }
                }
            })
        }
    }
})