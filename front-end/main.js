var app3 = new Vue({
  el: "#app",
  data: {
    books: [],
    id: "",
    name: "",
    press: "",
  },
  methods: {
    submit: function () {
      let vue_this = this;
      axios
        .post("http://localhost:8080/searchBook", {
          id: vue_this.id,
          name: vue_this.name,
          press: vue_this.press,
        })
        .then(function (response) {
          vue_this.books = response.data.data;
        })
        .catch(function (error) {
          alert(error);
        });
    },
    deleteById: function (bookId) {
      let vue_this = this;
      axios
        .delete("http://localhost:8080/book/" + bookId)
        .then(function (response) {
          if (response.data.success) {
            axios
              .post("http://localhost:8080/searchBook", {
                id: vue_this.id,
                name: vue_this.name,
                press: vue_this.press,
              })
              .then(function (response) {
                vue_this.books = response.data.data;
              })
              .catch(function (error) {
                alert(error);
              });
          } else {
            alert(response.data.msg);
          }
        })
        .catch(function (error) {
          alert(error);
        });
    },
  },
  beforeMount: function () {
    let vue_this = this;
    axios
      .get("http://localhost:8080/books")
      .then(function (response) {
        console.log(response);
        console.log(response.data.data);
        vue_this.books = response.data.data;
      })
      .catch(function (error) {
        alert(error);
      });
  },
});
