function slimper($sliderContainer) {
    let $buttonContainer = $sliderContainer.querySelector('.buttons');
    let $dotsContainer = $sliderContainer.querySelector('.dots-list');
    let $slideContainer = $sliderContainer.querySelectorAll('.slide img');
    let currentSlide = 0;
    
    $buttonContainer.querySelector('.btn-left').addEventListener('click',function(){
      if(currentSlide > 0){
        return showSlide(currentSlide - 1);
      }
      showSlide($slideContainer.length - 1);
    });
    
    $buttonContainer.querySelector('.btn-right').addEventListener('click',function(){
      if(currentSlide < $slideContainer.length - 1) {
        return showSlide(currentSlide + 1);
      }
      showSlide(0);
    });
    
    $slideContainer.forEach(function(slide,i){
      slide.style.opacity = 0;
    });
    
    function showSlide(slideIndex) {
      let $oldSlide = $slideContainer[currentSlide];
      let $newSlide = $slideContainer[slideIndex];
      
      if($oldSlide){
        $oldSlide.style.opacity = 0;
        $oldSlide.dot.classList.remove('active');
      } 
      $newSlide.style.opacity = 1;
      $newSlide.dot.classList.add('active');
      
      currentSlide = slideIndex;
      return true;
      
    }
    
    function buildDots() {
      if(!$dotsContainer){
        $dotsContainer = document.createElement('div');
        $dotsContainer.classList.add('dots-list');
        $sliderContainer.appendChild($dotsContainer);
      }
      for(let i = 0; i < $slideContainer.length; i++) {
        let $dot = document.createElement('span');
        $dot.classList.add('dots-item');
        $dot.addEventListener('click', showSlide.bind(this,i));
        $dotsContainer.appendChild($dot);
        $slideContainer[i].dot = $dot;
      }
    }
    
    buildDots();
    showSlide(0); 
  }
  
  slimper(document.querySelector('.slider'));