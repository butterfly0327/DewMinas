//부모 클래스 가장 앞 이니셜 따서 버튼 이름들 지정
//button_ci=>container_introdce
const frame = document.querySelector(".form");

document.addEventListener('DOMContentLoaded', function() {
  document.querySelectorAll('.toggle-button').forEach(button => {
      const sectionName = button.getAttribute('data-section');

      // 로컬 저장소에서 해당 섹션의 'hidden' 상태와 'activate' 상태를 확인하고 복원
      const isHidden = localStorage.getItem(`section-${sectionName}-hidden`) === 'true';
      const isActivated = localStorage.getItem(`button-${sectionName}-activate`) === 'true';

      // 초기 상태 설정: 섹션과 자식 요소들의 'hidden' 클래스를 설정
      const section = document.querySelector(`[name="${sectionName}"]`);
      if (section) {
          if (isHidden) {
              section.classList.add('hidden');
              Array.from(section.children).forEach(child => child.classList.add('hidden'));
          }
      }

      // 버튼의 'activate' 상태 복원
      if (isActivated) {
          button.classList.add("activate");
      }

      button.addEventListener('click', () => {
          // 버튼 클릭 시 'activate' 클래스를 토글
          const isNowActivated = button.classList.toggle("activate");

          // 버튼의 'activate' 상태를 로컬 저장소에 저장
          localStorage.setItem(`button-${sectionName}-activate`, isNowActivated);

          // 버튼 클릭 시 해당 섹션을 찾고 'hidden' 클래스를 토글
          if (section) {
              const isNowHidden = section.classList.toggle('hidden');
              
              // 자식 요소들에 'hidden' 클래스도 토글
              Array.from(section.children).forEach(child => {
                  child.classList.toggle('hidden', isNowHidden);
              });

              // plusbutton도 섹션 내 자식 요소로 취급하여 'hidden' 클래스를 토글
              const plusButton = section.querySelector('.plusbutton');
              if (plusButton) {
                  plusButton.classList.toggle('hidden', isNowHidden);
              }

              // 섹션의 'hidden' 상태를 로컬 저장소에 저장
              localStorage.setItem(`section-${sectionName}-hidden`, isNowHidden);
          }
      });
  });
});



///////////////////////////////////////////////plusbutton
document.addEventListener('DOMContentLoaded', function() {
  // 초기 로드 시 각 섹션별로 저장된 추가 필드를 로드
  document.querySelectorAll('.plusbutton').forEach(button => {
    const section = button.getAttribute('data-section');
    const savedFieldCount = parseInt(localStorage.getItem(`fieldCount-${section}`)) || 0;

    // 저장된 필드셋 수만큼 추가
    for (let i = 0; i < savedFieldCount; i++) {
      addFieldSet(section, button);
    }
  });
});

document.querySelectorAll('.plusbutton').forEach(button => {
  button.addEventListener('click', (e) => {
      const section = e.currentTarget.getAttribute('data-section');
      addFieldSet(section, e.currentTarget);  // plusbutton을 인자로 넘겨줌

      // 필드셋 추가 후 필드 수 저장
      const fieldCountKey = `fieldCount-${section}`;
      const currentCount = parseInt(localStorage.getItem(fieldCountKey)) || 0;
      localStorage.setItem(fieldCountKey, currentCount + 1);
  });
});

function addFieldSet(section, plusButton) {
  let template, container;

  switch (section) {
      case 'skill':
          template = document.querySelector('.maincontainer[name="skill"] .contentframe');
          container = document.querySelector('.maincontainer[name="skill"] .mainframe');
          break;
      case 'career':
          template = document.querySelector('.maincontainer[name="career"] .container-4');
          container = document.querySelector('.maincontainer[name="career"] .mainframe');
          break;
      case 'experience':
          template = document.querySelector('.maincontainer[name="experience"] .container-6');
          container = document.querySelector('.maincontainer[name="experience"] .mainframe');
          break;
      case 'reward':
          template = document.querySelector('.maincontainer[name="reward"] .container-7');
          container = document.querySelector('.maincontainer[name="reward"] .mainframe');
          break;
      case 'education':
          template = document.querySelector('.maincontainer[name="education"] .container-8');
          container = document.querySelector('.maincontainer[name="education"] .mainframe');
          break;
      case 'lisence':
          template = document.querySelector('.maincontainer[name="lisence"] .container-2');
          container = document.querySelector('.maincontainer[name="lisence"] .mainframe');
          break;
      default:
          console.warn(`Unknown section: ${section}`);
          return;
  }

  // 필드셋 복제 및 초기화
  const newFieldSet = template.cloneNode(true);
  newFieldSet.querySelectorAll('input, textarea').forEach(input => input.value = '');
  container.appendChild(newFieldSet);
}

document.addEventListener('DOMContentLoaded', function() {
  const previewButton = document.querySelector('#preview'); // 미리보기 버튼

  previewButton.addEventListener('click', function() {
    const allData = {};

    // 모든 입력 값 수집, hidden 클래스가 없는 요소만
    document.querySelectorAll('.text_area, .text_area_1').forEach(input => {
      if (!input.closest('.hidden')) { // input 요소가 hidden 클래스를 포함한 부모 요소 내에 있는지 확인
        const name = input.getAttribute('name');
        if (!allData[name]) allData[name] = []; // 배열 형태로 초기화하여 여러 입력을 수집
        allData[name].push(input.value);
      }
    });

    // 데이터를 JSON 문자열로 변환하여 localStorage에 저장
    localStorage.setItem('formData', JSON.stringify(allData));

    // 미리보기 페이지로 이동
    window.location.href = './portfolio_preview.html';
  });
});

document.querySelectorAll('.image-wrapper').forEach(wrapper => {
  wrapper.addEventListener('click', function() {
    // 클릭된 이미지-wrapper의 부모 요소를 찾고, 그 부모 요소를 제거
    const parentElement = wrapper.parentElement;
    if (parentElement) {
      parentElement.remove(); // 부모 요소를 제거
    }
  });
});
