

function getData (url){
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function() {
        const myObj = JSON.parse(this.responseText);
        for (var i = 0; i < 10; i++) {
    
             document.getElementById("demo"+i).innerHTML = 
                "<div class=\"left\"><img src="
                + myObj.articles[i].image 
                + "></div><div class=\"right\"><h3 class=\"title\"><a target=\"_blank\" href="
                + myObj.articles[i].url
                + ">"
                + myObj.articles[i].title
                + "</a></h3><br>"
                + myObj.articles[i].publishedAt
                + "<br><br><p class=\"des\">"
                + myObj.articles[i].description
                + "</p></div>";
        }    
    };
    xmlhttp.open("GET", url);   
    xmlhttp.send();
}
// lay nut submit thong tin
var submit = document.getElementById('submit');

var topUrl = 'https://gnews.io/api/v4/top-headlines?token=83b999af5390228f603acd326325452c&lang=en';

getData (topUrl);

submit.onclick = function (){
    
    // lay tu khoa
    var keywords = document.getElementById('keywords').value;

    var searchUrl = 
    'https://gnews.io/api/v4/search?q='
    + keywords 
    +'&token=83b999af5390228f603acd326325452c&lang=en';
    
    getData (searchUrl);
    modal.style.display = "none";
};




// toggle div modal box
var modal = document.getElementById("myModal");

var btn = document.getElementById("search");

var span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
  modal.style.display = "block";
}

span.onclick = function() {
  modal.style.display = "none";
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}