### Step 4: JavaScript (script.js)
Add functionality using JavaScript and a third-party API for file conversion.

javascript
document.getElementById('convertBtn').addEventListener('click', async () => {
  const fileInput = document.getElementById('fileInput');
  const format = document.getElementById('format').value;
  const downloadLink = document.getElementById('downloadLink');

  if (fileInput.files.length === 0) {
    alert('Please select a file.');
    return;
  }

  const file = fileInput.files[0];
  const formData = new FormData();
  formData.append('file', file);
  formData.append('format', format);

  try {
    // Replace with your API endpoint (e.g., CloudConvert or PDF.co)
    const response = await fetch('https://api.example.com/convert', {
      method: 'POST',
      body: formData,
    });

    if (!response.ok) {
      throw new Error('Conversion failed.');
    }

    const blob = await response.blob();
    const url = URL.createObjectURL(blob);

    downloadLink.href = url;
    downloadLink.download = `converted-file.${format}`;
    downloadLink.style.display = 'block';
    downloadLink.textContent = `Download ${format.toUpperCase()} File`;
  } catch (error) {
    console.error('Error:', error);
    alert('An error occurred during conversion.');
  }
});

// Advanced Tools (Placeholder Functions)
document.getElementById('compressBtn').addEventListener('click', () => {
  alert('Compress PDF feature coming soon!');
});

document.getElementById('mergeBtn').addEventListener('click', () => {
  alert('Merge PDFs feature coming soon!');
});

document.getElementById('splitBtn').addEventListener('click', () => {
  alert('Split PDF feature coming soon!');
});
