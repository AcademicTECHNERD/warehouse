
addEventListener('load',function(){
    var reStart = document.querySelector('.logo');
    var flag = 0;
    var nav = document.querySelector('.nav_top');
    var btn = nav.querySelector('button');
    var uls = nav.querySelector('ul');
    var search_top = nav.querySelector('.hidden_search');
    reStart.addEventListener('clock',function(){
        location.reload();
    })
    btn.addEventListener('click',function(){
        if(flag == 0){
            uls.style.display = 'none';
            search_top.style.display = 'block';
            flag=+1;
        }else{
            uls.style.display = 'block';
            search_top.style.display = 'none';

            flag = 0 ;
        }
        
    })

})
