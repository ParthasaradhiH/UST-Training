function numberToWords(num) {
const ones = [
    "",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
];
const tens = [
    "",
    "",
    "twenty",
    "thirty",
    "forty",
    "fifty",
    "sixty",
    "seventy",
    "eighty",
    "ninety",
];
const teens = [
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen",
];

if (num < 10) return ones[num];
if (num < 20) return teens[num - 10];
if (num < 100)
    return (
    tens[Math.floor(num / 10)] + (num % 10 ? " " + ones[num % 10] : "")
    );
if (num < 1000)
    return (
    ones[Math.floor(num / 100)] +
    " hundred" +
    (num % 100 ? " and " + numberToWords(num % 100) : "")
    );
if (num < 100000)
    return (
    numberToWords(Math.floor(num / 1000)) +
    " thousand" +
    (num % 1000 ? " " + numberToWords(num % 1000) : "")
    );
return (
    numberToWords(Math.floor(num / 100000)) +
    " lakh" +
    (num % 100000 ? " " + numberToWords(num % 100000) : "")
);
}


document.getElementById("invoiceForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const invoiceNo = document.getElementById("invoiceNo").value;
  const date = document.getElementById("date").value;

  const clientName = document.getElementById("clientName").value;
  const clientAddress = document.getElementById("clientAddress").value;
  const clientContact = document.getElementById("clientContact").value;
  const poNo = document.getElementById("poNo").value;
  const companyName = document.getElementById("companyName").value;
  const companyAddress = document.getElementById("companyAddress").value;
  const trainerName = document.getElementById("trainerName").value;
  const trainerPhone = document.getElementById("trainerPhone").value;

  const bankName = document.getElementById("bankName").value;
  const accountNo = document.getElementById("accountNo").value;
  const ifscCode = document.getElementById("ifscCode").value;
  const accountHolder = document.getElementById("accountHolder").value;
  const panNo = document.getElementById("panNo").value;
  const bankAddress = document.getElementById("bankAddress").value;

  let totalAmount = 0;

  const serviceRows = document.querySelectorAll(".service-row");
  const serviceTableBody = document.querySelector("#invoice tbody");
  serviceTableBody.innerHTML = "";

  serviceRows.forEach((row, index) => {
    const description = row.querySelector(".description").value;
    const rateType = row.querySelector(".rateType").value;
    const quantity = parseFloat(row.querySelector(".quantity").value);
    const rate = parseFloat(row.querySelector(".rate").value);

    const amount = quantity * rate;
    totalAmount += amount;

    const serviceRow = document.createElement("tr");
    serviceRow.innerHTML = `
      <td>${description}</td>
      <td>${quantity} ${rateType === "hourly" ? "Hours" : "Days"}</td>
      <td>${rate}</td>
      <td>${amount}</td>
    `;
    serviceTableBody.appendChild(serviceRow);
  });

  document.getElementById("displayInvoiceNo").textContent = invoiceNo;
  document.getElementById("displayDate").textContent = date;

  document.getElementById("displayClientName").textContent = clientName;
  document.getElementById("displayClientAddress").textContent = clientAddress;
  document.getElementById("displayClientContact").textContent = clientContact;
  document.getElementById("displayPoNo").textContent = poNo;
  document.getElementById("displayCompanyName").textContent = companyName;
  document.getElementById("displayCompanyAddress").textContent = companyAddress;
  document.getElementById("displayTrainerName").textContent = trainerName;
  document.getElementById("displayTrainerPhone").textContent = trainerPhone;
  document.getElementById("displayTrainerName2").textContent = trainerName;

  document.getElementById("displayTotal").textContent = totalAmount;
  document.getElementById("displayAmountInWords").textContent = numberToWords(totalAmount) + " rupees only";

  document.getElementById("displayBankName").textContent = bankName;
  document.getElementById("displayAccountNo").textContent = accountNo;
  document.getElementById("displayIfscCode").textContent = ifscCode;
  document.getElementById("displayaccountHolder").textContent = accountHolder;
  document.getElementById("displaypanNo").textContent = panNo;
  document.getElementById("displaybankAddress").textContent = bankAddress;

  document.getElementById("invoiceForm").style.display = "none";
  document.getElementById("invoice").style.display = "block";
});

function editInvoice() {
  document.getElementById("invoiceForm").style.display = "block";
  document.getElementById("invoice").style.display = "none";
}


let serviceCounter = 0;

function addService() {
  serviceCounter++;
  const serviceContainer = document.getElementById("serviceContainer");

  const newServiceRow = document.createElement("div");
  newServiceRow.classList.add("service-row");
  newServiceRow.setAttribute("id", `service-${serviceCounter}`);

  newServiceRow.innerHTML = `
    <div class="form-row">
      <div class="form-group">
        <label for="description-${serviceCounter}">Description:</label>
        <input type="text" class="description" id="description-${serviceCounter}" required />
      </div>
      <div class="form-group">
        <label for="rateType-${serviceCounter}">Rate Type:</label>
        <select class="rateType" id="rateType-${serviceCounter}" required>
          <option value="hourly">Hourly Rate</option>
          <option value="daily">Daily Rate</option>
        </select>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group">
        <label for="quantity-${serviceCounter}">Number of Hours/Days:</label>
        <input type="number" class="quantity" id="quantity-${serviceCounter}" required />
      </div>
      <div class="form-group">
        <label for="rate-${serviceCounter}">Rate (INR):</label>
        <input type="number" class="rate" id="rate-${serviceCounter}" required />
      </div>
    </div>
  `;

  serviceContainer.appendChild(newServiceRow);
}


function downloadInvoice() {
    const invoice = document.getElementById("invoice");

    const options = {
        margin: 1,
        filename: 'Invoice.pdf',
        image: { type: 'jpeg', quality: 0.98 },
        html2canvas: { scale: 2 },
        jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
    };

    html2pdf().from(invoice).set(options).save();
 }
