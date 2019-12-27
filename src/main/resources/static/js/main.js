app1 = new Vue({
   el: '#main',
   data:{
        message:"Hello",
       isArticle: false,
   },
    methods: {
        showArticle: function () {
            this.isArticle = true;

        },
        closeArticle: function () {
            this.isArticle = false;
        }
    },
});