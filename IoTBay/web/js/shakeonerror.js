/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('input[type=submit]').on('click', function(e){
  e.preventDefault();
  $('form').addClass('ahashakeheartache');
});

$('form').on('webkitAnimationEnd oanimationend msAnimationEnd animationend', function(e){
  $('form').delay(200).removeClass('ahashakeheartache');
});
