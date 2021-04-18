let tagsApp = new Vue({
    el: '#tagsApp',
    data:{
        tags: []
    },
    methods: {
        loadTags: function (){
            $.ajax({
                url: '/api-question/v1/tags',
                success:function (json){
                    tagsApp.tags = json.data
                }
            })
        }
    },
    created: function (){
        this.loadTags()
    }
})