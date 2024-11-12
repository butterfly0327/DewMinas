const allData = JSON.parse(localStorage.getItem('formData'));  // 저장된 데이터 가져오기
document.addEventListener("DOMContentLoaded", function() {
    const previewDiv = document.getElementById('previewDiv'); // 데이터를 표시할 요소
  
    // localStorage에서 formData를 가져와 allData로 파싱
    const allData = JSON.parse(localStorage.getItem('formData'));
    // 가져온 데이터가 있는 경우에만 previewDiv에 출력
    if (allData) {
      for (const [key, values] of Object.entries(allData)) {
        const item = document.createElement('p');
        item.textContent = `${key}: ${values.join(', ')}`; // 각 key와 값을 표시
        previewDiv.appendChild(item);
      }
    } else {
      previewDiv.textContent = '저장된 데이터가 없습니다.'; // 데이터가 없을 때 표시
    }
  });
  
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
        fullName.textContent = data.name && data.name[0] ? `${data.name[0]} (${data.englishName ? data.englishName[0] : ''})` : "이원준 (WONJUN LEE)";
        introFrame.appendChild(fullName);

        const role = document.createElement("p");
        role.classList.add("role");
        role.textContent = data.role && data.role[0] ? data.role[0] : "Software Engineer";
        introFrame.appendChild(role);

        const phoneNumber = document.createElement("p");
        phoneNumber.classList.add("contact-info");
        phoneNumber.textContent = data.phone && data.phone[0] ? `Phone. ${data.phone[0]}` : "Phone. 010-1234-5678";
        introFrame.appendChild(phoneNumber);

        const emailAddress = document.createElement("p");
        emailAddress.classList.add("contact-info");
        emailAddress.textContent = data.email && data.email[0] ? `e-mail. ${data.email[0]}` : "e-mail. evenil0206@gmail.com";
        introFrame.appendChild(emailAddress);

        introContainer.appendChild(introFrame);
        portfolioContainer.appendChild(introContainer);
    }

    function createEducationSection(allData) {
        // allData.educationList가 비어 있으면 함수 종료
        if (!allData.educationList || allData.educationList.length === 0) return;
    
        // Education 섹션 컨테이너 생성
        const educationContainer = document.createElement("div");
        educationContainer.classList.add("content-container");
        educationContainer.setAttribute("name", "education");
    
        // 섹션 제목 생성
        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Education /";
        educationContainer.appendChild(title);
    
        // 각 교육 항목을 처리
        allData.educationList.forEach((education, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");
    
            // Bullet Point 생성
            const bulletPoint = document.createElement("p");
            bulletPoint.classList.add("content-0");
            bulletPoint.textContent = "•";
            contentFrame.appendChild(bulletPoint);
    
            // 교육 정보 생성
            const educationInfo = document.createElement("p");
            educationInfo.classList.add("content-1");
            educationInfo.textContent = `${education. institution_name || "대학교"} / ${education.department || "컴퓨터공학과"} / ${education.degree || "학사"}`;
            contentFrame.appendChild(educationInfo);
            // GPA 정보 생성
            const ty = document.createElement("p");
            ty.classList.add("content-1");
            ty.textContent = `${education.to_now === "1" ? "재학중" : "졸업"}`;
            contentFrame.appendChild(ty);
            // GPA 정보 생성
            const gpa = document.createElement("p");
            gpa.classList.add("content-2");
            gpa.textContent = `GPA : ${education.gpa || "4.49"} / ${education.max_gpa || "4.5"}`;
            contentFrame.appendChild(gpa);
            

            const miniframe=document.createElement("div");
            miniframe.classList.add("miniframe");
            const date = document.createElement("p");
            date.classList.add("content-2")
            date.textContent = `${education.from_date || "2000.10.15"} ~ ${education.to_now === "1" ? new Date().toLocaleDateString() : education.to_date || "2000.10.15"}`;
            // 각 항목을 Education Container에 추가
            miniframe.appendChild(date);
            contentFrame.appendChild(miniframe);
            educationContainer.appendChild(contentFrame);

        });
    
        // 최종적으로 portfolioContainer에 Education 섹션 추가
        portfolioContainer.appendChild(educationContainer);
    }
    
    function createLicenseSection(allData) {
        // allData.licenseList가 비어 있으면 함수 종료
        if (!allData.licenseList || allData.licenseList.length === 0) return;
        
        // License 섹션 컨테이너 생성
        const licenseContainer = document.createElement("div");
        licenseContainer.classList.add("content-container");
        licenseContainer.setAttribute("name", "license");
    
        // 섹션 제목 생성
        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ License /";
        licenseContainer.appendChild(title);
    
        // 각 라이센스 항목을 처리
        allData.licenseList.forEach((license, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");
    
            // Bullet Point 생성
            const bulletPoint = document.createElement("p");
            bulletPoint.classList.add("content-0");
            bulletPoint.textContent = "•";
            contentFrame.appendChild(bulletPoint);
    
            // 라이센스 정보 생성
            const licenseInfo = document.createElement("p");
            licenseInfo.classList.add("content-1");
            licenseInfo.textContent = `${license.name || "정보처리기사"}`;
            contentFrame.appendChild(licenseInfo);
    
            
            // 날짜 정보 생성
            const miniframe = document.createElement("div");
            miniframe.classList.add("miniframe");

            const organization = document.createElement("p");
            organization.classList.add("content-2");
            organization.textContent=`${license.organization_name || "국가가 인증하는 기관"}`;
            miniframe.appendChild(organization);

            const date = document.createElement("p");
            date.classList.add("content-2");
            date.textContent = `${license.issued_date || "2000.10.15"}`;
            
            miniframe.appendChild(date);
            contentFrame.appendChild(miniframe);
    
            // 각 항목을 License Container에 추가
            licenseContainer.appendChild(contentFrame);
        });
    
        
        portfolioContainer.appendChild(licenseContainer);
    }
    

    // Awards 섹션 생성
    function createAwardsSection(data) {
        // 만약 data.awards.name이 비어 있으면 함수를 종료
        if (!data.awardList || data.awardList.length === 0) return;

        const awardsContainer = document.createElement("div");
        awardsContainer.classList.add("content-container");
        awardsContainer.setAttribute("name", "award");

        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Awards /";
        awardsContainer.appendChild(title);

        data.awards.name.forEach((name, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");

            const bulletPoint = document.createElement("p");
            bulletPoint.classList.add("content-0");
            bulletPoint.textContent = "•";
            contentFrame.appendChild(bulletPoint);

            const awardTitle = document.createElement("p");
            awardTitle.classList.add("content-3");
            awardTitle.textContent = name || "2024년 하계, 동계 계절학기 캡스톤 디자인 경진대회 장려상";
            contentFrame.appendChild(awardTitle);

            const awardOrganizer = document.createElement("p");
            awardOrganizer.classList.add("content-4");
            awardOrganizer.textContent = data.awards.organizer[index] || "동의대학교 LINC+ 사업단";
            contentFrame.appendChild(awardOrganizer);

            const awardDate = document.createElement("p");
            awardDate.classList.add("content-4");
            awardDate.textContent = data.awards.year[index] || "2020-11";
            contentFrame.appendChild(awardDate);

            awardsContainer.appendChild(contentFrame);
        });

        portfolioContainer.appendChild(awardsContainer);
    }

    // Experience 섹션 생성
    function createExperienceSection(data) {
        // 만약 data.experience.name이 비어 있으면 함수를 종료
        if (!data.experience || !data.experience.name || data.experience.name.length === 0) return;

        const experienceContainer = document.createElement("div");
        experienceContainer.classList.add("content-container");
        experienceContainer.setAttribute("name", "experience");

        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Experience /";
        experienceContainer.appendChild(title);

        data.experience.name.forEach((name, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");

            const bulletPoint = document.createElement("p");
            bulletPoint.classList.add("content-0");
            bulletPoint.textContent = "•";
            contentFrame.appendChild(bulletPoint);

            const experienceTitle = document.createElement("p");
            experienceTitle.classList.add("content-3");
            experienceTitle.textContent = name || "미래 내일 일 경험 프로그램 프로젝트형 수료";
            contentFrame.appendChild(experienceTitle);

            const experienceOrganizer = document.createElement("p");
            experienceOrganizer.classList.add("content-4");
            experienceOrganizer.textContent = data.experience.organizer[index] || "한국융합인재교육협회";
            contentFrame.appendChild(experienceOrganizer);

            const experienceDate = document.createElement("p");
            experienceDate.classList.add("content-4");
            const startYear = data.experience.startYear[index] || "2020-10-10";
            const endYear = data.experience.endYear[index] || "2021-10-12";
            experienceDate.textContent = `${startYear} - ${endYear}`;
            contentFrame.appendChild(experienceDate);

            experienceContainer.appendChild(contentFrame);
        });

        portfolioContainer.appendChild(experienceContainer);
    }

    function createWorkExperienceSection(data) {

        const workExperienceContainer = document.createElement("div");
        workExperienceContainer.classList.add("content-container");
        workExperienceContainer.setAttribute("name", "workExperience");
    
        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Work Experience /";
        workExperienceContainer.appendChild(title);
    
        data.workExpList.forEach((workExp, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");
    
            // 회사명
            const companyName = document.createElement("p");
            companyName.classList.add("content-3");
            companyName.textContent = workExp.company_name || "Unknown Company";
            contentFrame.appendChild(companyName);
    
            // 직책
            const jobTitle = document.createElement("p");
            jobTitle.classList.add("content-4");
            jobTitle.textContent = workExp.job_title || "Unknown Job Title";
            contentFrame.appendChild(jobTitle);
    
            // 기간 (시작일 - 종료일)
            const workPeriod = document.createElement("p");
            workPeriod.classList.add("content-4");
            workPeriod.textContent = `${workExp.from_date || "Start Date"} - ${workExp.to_date || "End Date"}`;
            contentFrame.appendChild(workPeriod);
    
            // 업무 내용
            const responsibilities = document.createElement("p");
            responsibilities.classList.add("content-5");
            responsibilities.textContent = workExp.responsibilities || "No responsibilities listed.";
            contentFrame.appendChild(responsibilities);
    
            workExperienceContainer.appendChild(contentFrame);
        });
    
        portfolioContainer.appendChild(workExperienceContainer);
    }
    
    // Skills 섹션 생성
    function createSkillsSection(data) {
        // 만약 data.skills.name이 비어 있으면 함수를 종료
        if (!data.skills || !data.skills.name || data.skills.name.length === 0) return;

        const skillsContainer = document.createElement("div");
        skillsContainer.classList.add("content-container");
        skillsContainer.setAttribute("name", "skill");

        const title = document.createElement("h2");
        title.classList.add("content-head");
        title.textContent = "/ Skills /";
        skillsContainer.appendChild(title);

        data.skills.name.forEach((name, index) => {
            const contentFrame = document.createElement("div");
            contentFrame.classList.add("content-frame");

            const skillContainer = document.createElement("div");
            skillContainer.classList.add("skill-container");

            const levelImg = document.createElement("img");
            levelImg.classList.add("svg");
            levelImg.setAttribute("src", data.skills.level[index] ? `img/${data.skills.level[index]}.png` : "img/level_2.png");
            skillContainer.appendChild(levelImg);

            const skillImg = document.createElement("img");
            skillImg.classList.add("skill-img");
            skillImg.setAttribute("src", name ? `img/${name}.png` : "img/java.png");
            skillContainer.appendChild(skillImg);

            const skillText = document.createElement("p");
            skillText.classList.add("skill-txt");
            skillText.textContent = data.skills.introduce[index] || "기술에 대한 설명이 없습니다.";
            skillContainer.appendChild(skillText);

            contentFrame.appendChild(skillContainer);
            skillsContainer.appendChild(contentFrame);
        });

        portfolioContainer.appendChild(skillsContainer);
    }

    // 호출
    createIntroSection(allData);
    createEducationSection(allData);
    createLicenseSection(allData);
    createAwardsSection(allData);
    createExperienceSection(allData);
    createWorkExperienceSection(allData);
    createSkillsSection(allData);
});
