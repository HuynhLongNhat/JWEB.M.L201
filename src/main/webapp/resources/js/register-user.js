document.getElementById('registerForm').addEventListener('submit', function (event) {
    event.preventDefault();
    let isValid = true;
    let errorMessage = ''; // Khởi tạo chuỗi thông báo lỗi

    // Reset error messages
    document.querySelectorAll('.error-message').forEach(el => el.textContent = '');
    document.getElementById('formMessage').textContent = ''; // Reset form message

    const firstName = document.getElementById('firstName');
    const lastName = document.getElementById('lastName');
    const email = document.getElementById('email');
    const userName = document.getElementById('userName');
    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');

    // Kiểm tra từng trường
    if (firstName.value.trim() === "") {
        isValid = false;
        firstName.classList.add('error');
        firstName.classList.remove('success');
        firstName.style.borderColor = 'red'; 
        errorMessage += 'First name is required.<br>';
    } else if (firstName.value.trim().length < 5) {
        isValid = false;
        firstName.classList.add('error');
        firstName.classList.remove('success');
        firstName.style.borderColor = 'red'; 
        errorMessage += 'First name must be at least 5 characters.<br>';
    } else {
        firstName.classList.add('success'); 
        firstName.classList.remove('error'); 
        firstName.style.borderColor = 'green'; 
    }

    if (lastName.value.trim() === "") {
        isValid = false;
        lastName.classList.add('error');
        lastName.classList.remove('success');
        lastName.style.borderColor = 'red';
        errorMessage += 'Last name is required.<br>';
    } else if (lastName.value.trim().length < 5) {
        isValid = false;
        lastName.classList.add('error');
        lastName.classList.remove('success');
        lastName.style.borderColor = 'red';
        errorMessage += 'Last name must be at least 5 characters.<br>';
    } else {
        lastName.classList.add('success');
        lastName.classList.remove('error');
        lastName.style.borderColor = 'green';
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email.value)) {
        isValid = false;
        email.classList.add('error');
        email.classList.remove('success');
        email.style.borderColor = 'red';
        errorMessage += 'Invalid email format.<br>';
    } else {
        email.classList.add('success');
        email.classList.remove('error');
        email.style.borderColor = 'green';
    }

    if (userName.value.trim() === "") {
        isValid = false;
        userName.classList.add('error');
        userName.classList.remove('success');
        userName.style.borderColor = 'red';
        errorMessage += 'Username is required.<br>';
    } else if (userName.value.trim().length < 5) {
        isValid = false;
        userName.classList.add('error');
        userName.classList.remove('success');
        userName.style.borderColor = 'red';
        errorMessage += 'Username must be at least 5 characters.<br>';
    } else {
        userName.classList.add('success');
        userName.classList.remove('error');
        userName.style.borderColor = 'green';
    }

    if (password.value.trim() === "") {
        isValid = false;
        password.classList.add('error');
        password.classList.remove('success');
        password.style.borderColor = 'red';
        errorMessage += 'Password is required.<br>';
    } else if (password.value.trim().length < 6) {
        isValid = false;
        password.classList.add('error');
        password.classList.remove('success');
        password.style.borderColor = 'red';
        errorMessage += 'Password must be at least 6 characters.<br>';
    } else {
        password.classList.add('success');
        password.classList.remove('error');
        password.style.borderColor = 'green';
    }

    if (confirmPassword.value !== password.value || confirmPassword.value.trim() === "") {
        isValid = false;
        confirmPassword.classList.add('error');
        confirmPassword.classList.remove('success');
        confirmPassword.style.borderColor = 'red';
        errorMessage += 'Passwords do not match.<br>';
    } else {
        confirmPassword.classList.add('success');
        confirmPassword.classList.remove('error');
        confirmPassword.style.borderColor = 'green';
    }

    // Nếu có lỗi
    if (!isValid) {
        document.getElementById('formMessage').innerHTML = errorMessage; // Hiển thị lỗi với line breaks
        document.getElementById('formMessage').style.color = 'red';
    } else {
        document.getElementById('formMessage').textContent = '';
        this.submit();
    }
});
