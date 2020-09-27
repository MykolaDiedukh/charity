document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          if(this.isValid()){
            this.currentStep++;
            this.updateForm();
          }
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          if(this.isValid()){
            this.currentStep--;
            this.updateForm();
          }

        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    isValid(){
      switch (this.currentStep) {
        case 1: {
          const checkBox = document.querySelectorAll("input[name=categories]:checked");
          if(checkBox.length===0){
            alert("Wybierz category, co najmniej jedną");
            return false;
          }
          break;
        }
        case 2: {
          const quantity = document.getElementById("quantity").value;
          if (quantity === ''){
            alert("Zapisz ilość worków");
            return false;
          }
          break;
        }
        case 3: {
          let radioFoundation =document.querySelector('#foundationRadio:checked');
          if (radioFoundation === null){
            alert("Wybierz organizacje");
            return false;
          }
          break;
        }
        case 4: {
          let street = document.getElementById("street").value;
          if (street === ''){
            alert("nazwa ulicy nie może być pusta");
            return false;
          }
          let city = document.getElementById("city").value;
          if (city === ''){
            alert("nazwa miasta nie może być pusta")
            return false;
          }
          let zip = document.getElementById("zip").value;
          if (zip.length<=4){
            alert("kod pocztowy musi mieć 5 cyfr")
            return false;
          }
          let phoneNumber = document.getElementById("phoneNumber").value;
          if (phoneNumber.length<=8){
            alert("Numer telefonu musi mieć 9 cyfr")
            return false;
          }
          let date = document.getElementById("date").value;
          if (date === ''){
            alert("Podaj date")
            return false;
          }
          let time = document.getElementById("time").value;
          if (!time.match("^([0-1][0-9]|[2][0-3]):([0-5][0-9])$")){
            alert("Wpisz prawidłową date")
            return false;
          }
          break;

        }
      }

      return true;
    }
    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation


      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // get data from inputs and show them in summary
      let checkboxCategory = document.querySelectorAll('#categoryCheckbox:checked');
      let categoryResult=document.getElementById('category-result');
      let categoryValue = [];

      checkboxCategory.forEach(function ( element) {
        categoryValue.push(element.parentElement.querySelector('span.description').innerText);
      })
      console.log(categoryValue);

      let worki = document.querySelector('#quantity');

      categoryResult.innerText=worki.value + ' worków ' + categoryValue.join(', ');



      let radioFoundation =document.querySelector('#foundationRadio:checked');
      let institution = document.getElementById('foundation-result');
      if (radioFoundation !== null){
        institution.innerText = radioFoundation.parentElement.querySelector('div.title').innerText;
      }

      let street = document.getElementById("street").value;
      document.getElementById("street-result").innerText = street;
      console.log(street)

      let city = document.getElementById("city").value;
      document.getElementById("city-result").innerText = city;
      console.log(city)

      let zipCode = document.getElementById("zip").value;
      document.getElementById("zipCode-result").innerText = zipCode;
      console.log(zipCode)

      let resumePhoneNumber = document.getElementById("phoneNumber").value;
      document.getElementById("phone-result").innerText = resumePhoneNumber;
      console.log(resumePhoneNumber)

      let resumeDate = document.getElementById("date").value;
      document.getElementById("date-result").innerText = resumeDate;
      console.log(resumeDate)

      let resumeTime = document.getElementById("time").value;
      document.getElementById("time-result").innerText = resumeTime;
      console.log(resumeTime)

      let resumeDetails = document.getElementById("comment").value;
      if (resumeDetails !== '') {
        document.getElementById("comment-result").innerText = resumeDetails;
      } else {
        document.getElementById("comment-result").innerText = 'Brak uwag';
      }
      console.log(resumeDetails)

    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }
});
