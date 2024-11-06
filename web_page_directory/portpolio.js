
const allData = JSON.parse(localStorage.getItem('formData'));  // 저장된 데이터 가져오기

document.addEventListener("DOMContentLoaded", function() {
    

    // 데이터가 없으면 바로 종료
    if (!allData) return;

    const portfolioContainer = document.querySelector(".main-container[name='portfolio-container']");

    // Intro 섹션 생성
    function createIntroSection(data) {
        const introContainer = document.createElement("div");
        introContainer.classList.add("intro-container");
        introContainer.setAttribute("name", "intro");

        const img = document.createElement("img");
        img.classList.add("intro-img");
        img.setAttribute("alt", "Png");
        img.setAttribute("src", "image2.png");  // 기본 이미지 설정
        introContainer.appendChild(img);

        const introFrame = document.createElement("div");
        introFrame.classList.add("intro-frame");

        const fullName = document.createElement("p");
        fullName.classList.add("name");
        fullName.textContent = data.p_name && data.p_name[0] ? `${data.p_name[0]} (${data.p_englishname ? data.p_englishname[0] : ''})` : "이원준 (WONJUN LEE)";
        introFrame.appendChild(fullName);

        const role = document.createElement("p");
        role.classList.add("role");
        role.textContent = data.p_englishname && data.p_englishname[0] ? data.p_englishname[0] : "Software Engineer";
        introFrame.appendChild(role);

        const phoneNumber = document.createElement("p");
        phoneNumber.classList.add("contact-info");
        phoneNumber.textContent = data.p_phone && data.p_phone[0] ? `Phone. ${data.p_phone[0]}` : "Phone. 010-1234-5678";
        introFrame.appendChild(phoneNumber);

        const emailAddress = document.createElement("p");
        emailAddress.classList.add("contact-info");
        emailAddress.textContent = data.p_email && data.p_email[0] ? `e-mail. ${data.p_email[0]}` : "e-mail. evenil0206@gmail.com";
        introFrame.appendChild(emailAddress);

        introContainer.appendChild(introFrame);
        portfolioContainer.appendChild(introContainer);
    }

    // Education 섹션 생성
    function createEducationSection(data) {
        // 만약 data.e_univercity가 비어 있으면 함수를 종료
        if (!data.e_univercity || data.e_univercity.length === 0) return;
    
        // 새로운 섹션 div 생성
        const educationContainer = document.createElement("div");
        educationContainer.classList.add("content-container");
        educationContainer.setAttribute("name", "education");
    
        // 섹션 제목 추가
        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Education /";
        educationContainer.appendChild(title);
    
        // data.e_univercity 배열을 순회하면서 각 항목을 추가
        data.e_univercity.forEach((university, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");
    
            // bulletPoint 추가
            const bulletPoint = document.createElement("p");
            bulletPoint.classList.add("content-0");
            bulletPoint.textContent = "•";
            contentFrame.appendChild(bulletPoint);
    
            // 대학 정보 추가
            const educationInfo = document.createElement("p");
            educationInfo.classList.add("content-1");
            educationInfo.textContent = `${university || "동의대학교"} / ${data.e_department[index] || "컴퓨터공학과"} / ${data.e_degree[index] || "학사"}`;
            contentFrame.appendChild(educationInfo);
    
            // GPA 정보 추가
            const gpa = document.createElement("p");
            gpa.classList.add("content-2");
            gpa.textContent = `GPA : ${data.e_score[index] || "4.49 / 4.5"}`;
            contentFrame.appendChild(gpa);
    
            // contentFrame를 educationContainer에 추가
            educationContainer.appendChild(contentFrame);
        });
    
        // main-container에 educationContainer 추가
        const portfolioContainer = document.querySelector(".main-container[name='portfolio-container']");
        if (portfolioContainer) {
            portfolioContainer.appendChild(educationContainer);
        }
    }
    
    
    function createAwardsSection(data) {
        // 만약 data.r_name이 비어 있으면 함수를 종료
        if (!data.r_name || data.r_name.length === 0) return;
    
        // 새로운 섹션 div 생성
        const awardsContainer = document.createElement("div");
        awardsContainer.classList.add("content-container");
        awardsContainer.setAttribute("name", "award");
    
        // 섹션 제목 추가
        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Awards /";
        awardsContainer.appendChild(title);
    
        // data.r_name 배열을 순회하면서 각 항목을 추가
        data.r_name.forEach((name, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");
    
            // bulletPoint 추가
            const bulletPoint = document.createElement("p");
            bulletPoint.classList.add("content-0");
            bulletPoint.textContent = "•";
            contentFrame.appendChild(bulletPoint);
    
            // 수상 제목 추가
            const awardTitle = document.createElement("p");
            awardTitle.classList.add("content-3");
            awardTitle.textContent = name || "2024년 하계, 동계 계절학기 캡스톤 디자인 경진대회 장려상";
            contentFrame.appendChild(awardTitle);
    
            // 수상 주최기관 추가
            const awardOrganizer = document.createElement("p");
            awardOrganizer.classList.add("content-4");
            awardOrganizer.textContent = data.r_institution[index] || "동의대학교 LINC+ 사업단";
            contentFrame.appendChild(awardOrganizer);
    
            // 수상 날짜 추가
            const awardDate = document.createElement("p");
            awardDate.classList.add("content-4");
            awardDate.textContent = data.r_year[index] || "2020-11";
            contentFrame.appendChild(awardDate);
    
            // contentFrame를 awardsContainer에 추가
            awardsContainer.appendChild(contentFrame);
        });
    
        // main-container에 awardsContainer 추가
        const portfolioContainer = document.querySelector(".main-container[name='portfolio-container']");
        if (portfolioContainer) {
            portfolioContainer.appendChild(awardsContainer);
        }
    }
    

    // Experience 섹션 생성
    function createExperienceSection(data) {
        // 만약 data.x_name이 비어 있으면 함수를 종료
        if (!data.x_name || data.x_name.length === 0) return;
    
        // 새로운 섹션 div 생성
        const experienceContainer = document.createElement("div");
        experienceContainer.classList.add("content-container");
        experienceContainer.setAttribute("name", "experience");
    
        // 섹션 제목 추가
        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Experience /";
        experienceContainer.appendChild(title);
    
        // data.x_name 배열을 순회하면서 각 항목을 추가
        data.x_name.forEach((name, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");
    
            // bulletPoint 추가
            const bulletPoint = document.createElement("p");
            bulletPoint.classList.add("content-0");
            bulletPoint.textContent = "•";
            contentFrame.appendChild(bulletPoint);
    
            // 경험 제목 추가
            const experienceTitle = document.createElement("p");
            experienceTitle.classList.add("content-3");
            experienceTitle.textContent = name || "미래 내일 일 경험 프로그램 프로젝트형 수료";
            contentFrame.appendChild(experienceTitle);
    
            // 경험 기관 추가
            const experienceOrganizer = document.createElement("p");
            experienceOrganizer.classList.add("content-4");
            experienceOrganizer.textContent = data.x_institution[index] || "한국융합인재교육협회";
            contentFrame.appendChild(experienceOrganizer);
    
            // 경험 시작 년도와 종료 년도 추가
            const experienceDate = document.createElement("p");
            experienceDate.classList.add("content-4");
            const startYear = data.x_start_year[index] || "2020-10-10";
            const endYear = data.x_end_year[index] || "2021-10-12";
            experienceDate.textContent = `${startYear} - ${endYear}`;
            contentFrame.appendChild(experienceDate);
    
            
    
            // contentFrame를 experienceContainer에 추가
            experienceContainer.appendChild(contentFrame);
        });
    
        // main-container에 experienceContainer 추가
        const portfolioContainer = document.querySelector(".main-container[name='portfolio-container']");
        if (portfolioContainer) {
            portfolioContainer.appendChild(experienceContainer);
        }
    }
    

    // Skills 섹션 생성
    function createSkillsSection(data) {
        // 만약 data.s_name이 비어 있으면 함수를 종료
        if (!data.s_name || data.s_name.length === 0) return;
    
        const skillsContainer = document.createElement("div");
        skillsContainer.classList.add("content-container");
        skillsContainer.setAttribute("name", "skill");
    
        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Skills /";
        skillsContainer.appendChild(title);
    
        // data.s_name 배열을 순회하면서 각 항목을 추가
        data.s_name.forEach((name, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");
    
            // 기술 이미지와 이름을 추가
            const skillContainer = document.createElement("div");
            skillContainer.classList.add("skill-container");
    const levelImg = document.createElement("img");
            levelImg.classList.add("svg");
            // 이미지 URL은 기본값으로 설정하거나 s_name에 맞는 이미지를 설정
            levelImg.setAttribute("src", data.s_level[index] ? `img/${data.s_level[index]}.png` : "img/level_2.png"); 
            skillContainer.appendChild(levelImg);
            // 기술 이미지는 name 값에 맞는 이미지를 선택
            const skillImg = document.createElement("img");
            skillImg.classList.add("skill-img");
            // 이미지 URL은 기본값으로 설정하거나 s_name에 맞는 이미지를 설정
            skillImg.setAttribute("src",name ? `img/${name}.png` : "img/java.png"); 
            skillContainer.appendChild(skillImg);

            
    
            // 기술 설명
            const skillText = document.createElement("p");
            skillText.classList.add("skill-txt");
            skillText.textContent = data.s_introduce[index] || "기술에 대한 설명이 없습니다.";
            contentFrame.appendChild(skillContainer);
            contentFrame.appendChild(skillText);
    
           
    
            // contentFrame를 skillsContainer에 추가
            skillsContainer.appendChild(contentFrame);
        });
    
        // main-container에 skillsContainer 추가
        const portfolioContainer = document.querySelector(".main-container[name='portfolio-container']");
        if (portfolioContainer) {
            portfolioContainer.appendChild(skillsContainer);
        }
    }
    

    // 각 섹션 생성 함수 호출
    createIntroSection(allData);
    createEducationSection(allData);
    createAwardsSection(allData);
    createExperienceSection(allData);

    createSkillsSection(allData);
});

