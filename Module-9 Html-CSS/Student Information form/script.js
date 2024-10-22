let students = [
    {
        id: 1,
        name: "Rahul Sharma",
        age: 20,
        gender: "Male",
        email: "rahul.sharma@example.com",
        phone: "9876543210",
        address: "123 MG Road, Mumbai, Maharashtra"
    },
    {
        id: 2,
        name: "Priya Menon",
        age: 22,
        gender: "Female",
        email: "priya.menon@example.com",
        phone: "9871234560",
        address: "45, Brigade Road, Bengaluru, Karnataka"
    },
    {
        id: 3,
        name: "Amit Patel",
        age: 21,
        gender: "Male",
        email: "amit.patel@example.com",
        phone: "9898989898",
        address: "78 Nehru Street, Ahmedabad, Gujarat"
    },
    {
        id: 4,
        name: "Anjali Singh",
        age: 23,
        gender: "Female",
        email: "anjali.singh@example.com",
        phone: "9872345671",
        address: "89 Civil Lines, Lucknow, Uttar Pradesh"
    },
    {
        id: 5,
        name: "Rajesh Kumar",
        age: 24,
        gender: "Male",
        email: "rajesh.kumar@example.com",
        phone: "9988776655",
        address: "32 Park Street, Chennai, Tamil Nadu"
    },
    {
        id: 6,
        name: "Sneha Iyer",
        age: 22,
        gender: "Female",
        email: "sneha.iyer@example.com",
        phone: "9873216540",
        address: "12 Kannan Street, Coimbatore, Tamil Nadu"
    },
    {
        id: 7,
        name: "Vikas Reddy",
        age: 21,
        gender: "Male",
        email: "vikas.reddy@example.com",
        phone: "9876540987",
        address: "56 Jubilee Hills, Hyderabad, Telangana"
    },
    {
        id: 8,
        name: "Neha Verma",
        age: 23,
        gender: "Female",
        email: "neha.verma@example.com",
        phone: "9988007766",
        address: "100 Connaught Place, New Delhi, Delhi"
    },
    {
        id: 9,
        name: "Siddharth Mehta",
        age: 22,
        gender: "Male",
        email: "siddharth.mehta@example.com",
        phone: "9870098765",
        address: "88 Bopal Road, Ahmedabad, Gujarat"
    },
    {
        id: 10,
        name: "Pooja Das",
        age: 24,
        gender: "Female",
        email: "pooja.das@example.com",
        phone: "9123456789",
        address: "20 Salt Lake, Kolkata, West Bengal"
    }
];


function displayStudents() {
    const container = document.getElementById('detailsContainer');
    container.innerHTML = ''; 

    students.forEach(student => {
        const studentCard = `
            <div class="student-card" data-id="${student.id}">
                <p><strong>Name:</strong> ${student.name}</p>
                <p><strong>Age:</strong> ${student.age}</p>
                <p><strong>Gender:</strong> ${student.gender}</p>
                <p><strong>Email:</strong> ${student.email}</p>
                <p><strong>Phone:</strong> ${student.phone}</p>
                <p><strong>Address:</strong> ${student.address}</p>
                <button onclick="editStudent(${student.id})">Edit</button>
                <button onclick="deleteStudent(${student.id})">Delete</button>
            </div>
        `;
        container.innerHTML += studentCard;
    });
}

document.getElementById('student-form').addEventListener('submit', function(event) {
    event.preventDefault(); 

    const name = document.getElementById('name').value;
    const age = document.getElementById('age').value;
    const gender = document.querySelector('input[name="gender"]:checked').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const address = document.getElementById('address').value;
    const studentId = document.getElementById('student-form').dataset.editingId;

    if (studentId) {
        const studentIndex = students.findIndex(student => student.id == studentId);
        students[studentIndex] = {
            id: studentId,
            name,
            age,
            gender,
            email,
            phone,
            address
        };
        document.getElementById('student-form').removeAttribute('data-editing-id');
    } else {
        const newStudent = {
            id: students.length + 1,
            name,
            age,
            gender,
            email,
            phone,
            address
        };
        students.push(newStudent);
    }

    document.getElementById('student-form').reset();
    displayStudents();
});

function deleteStudent(id) {
    students = students.filter(student => student.id !== id);
    displayStudents();
}

function editStudent(id) {
    const student = students.find(student => student.id === id);
    document.getElementById('name').value = student.name;
    document.getElementById('age').value = student.age;
    document.querySelector(`input[name="gender"][value="${student.gender}"]`).checked = true;
    document.getElementById('email').value = student.email;
    document.getElementById('phone').value = student.phone;
    document.getElementById('address').value = student.address;
    
    document.getElementById('student-form').dataset.editingId = student.id;
}

displayStudents();
