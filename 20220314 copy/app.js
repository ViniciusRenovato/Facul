const { json } = require('express');
const express = require('express');
const app = express();

//npm install ejs --save
app.set("view engine","ejs");

const moment = require('moment');

var S = require('string');

var noticia =  {
    news1 : '📜 Vasco emite comunicado em conjunto com a 777 Partners', imgnews1: 'https://oneftbl-cms.imgix.net/https%3A%2F%2Fwp-images.onefootball.com%2Fwp-content%2Fuploads%2Fsites%2F13%2F2022%2F06%2FBrasileirao-Series-A-Vasco-da-Gama-v-Goias-Play-Behind-Closed-Doors-Amidst-the-Coronavirus-COVID-19-Pandemic-1655855081-1000x667.jpg?auto=format%2Ccompress&crop=faces&dpr=2&fit=crop&h=630&q=25&w=840&s=66262b605171d7eaf3b3f3b9aefb7bbb', autornews1:'Alexandre Fernandes', datanews1:'21/06/2022',
    news2 :'Noticia Gabigol recebe críticas por video de rap em meio a crise no Flamengo', imgnews2:'https://oneftbl-cms.imgix.net/https%3A%2F%2Fmundorubronegro.com%2Fwp-content%2Fuploads%2F2022%2F06%2FFora-do-duelo-com-o-Fortaleza-Gabigol-curte-evento-de-musica-no-Rio-ao-lado-de-celebridades.png?auto=format%2Ccompress&crop=faces&dpr=2&fit=crop&h=630&q=25&w=840&s=bea2c74a4eaa8b507dd3e0d99168ea7d', autornews2:'Ivan Trindade', datanews1:'21/06/2022',
    news3 :'😉Presidente do PSG não garante permanência de Neymar: não posso falar', imgnews3: 'https://oneftbl-cms.imgix.net/https%3A%2F%2Fwp-images.onefootball.com%2Fwp-content%2Fuploads%2Fsites%2F13%2F2022%2F06%2FReal-Madrid-v-Paris-Saint-Germain-Round-Of-Sixteen-Leg-Two-UEFA-Champions-League-1655841581-1000x750.jpg?auto=format%2Ccompress&crop=faces&dpr=2&fit=crop&h=630&q=25&w=840&s=01d06657550c9068d1eaa777a05eae03', autornews1:'Leo Urnauer', datanews1:'21/06/2022'
}

var cont = 0;

app.get('/',(req,res)=>{
    var noticiatexto = '';
    var noticiaimg='';
    var id ='';
    if(cont == 0){
        id = '1';
        noticiatexto = noticia.news1;
        noticiaimg = noticia.imgnews1;
        cont++;
        res.render("news",{id:id,news:noticiatexto, newsimg:noticiaimg});
    }else if(cont == 1){
        id = '2';
        noticiatexto = noticia.news2;
        noticiaimg = noticia.imgnews2;
        cont++;
        res.render("news",{id:id,news:noticiatexto, newsimg:noticiaimg});
    }else if(cont == 2){
        id = '3';
        noticiatexto = noticia.news3;
        noticiaimg = noticia.imgnews3;
        cont = 0;
        res.render("news",{id:id,news:noticiatexto, newsimg:noticiaimg});
    }
});

app.get("/json1",(req,res)=>{
    var notic = {news1:noticia.news1,autornews1:noticia.autornews1,datanews1:noticia.datanews1,imgnews1:noticia.imgnews1};
    res.send(JSON.stringify(notic));
});
app.get("/json2",(req,res)=>{
    var notic = {news2:noticia.news2,autornews2:noticia.autornews2,datanews2:noticia.datanews2,imgnews2:noticia.imgnews2};
    res.send(JSON.stringify(noticia.news2+noticia.autornews2+noticia.datanews2+noticia.imgnews2));
});
app.get("/json3",(req,res)=>{
    var notic = {news3:noticia.news3,autornews3:noticia.autornews3,datanews3:noticia.datanews3,imgnews3:noticia.imgnews3};
    res.send(JSON.stringify(noticia.news3+noticia.autornews3+noticia.datanews3+noticia.imgnews3));
});

app.listen(3000);