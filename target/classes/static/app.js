function loadEvents() {
    const eventsDisplay = document.getElementById('events');
    eventsDisplay.innerHTML = '<div class="loading">Loading events...</div>';

    fetch('/events')
        .then(res => {
            if (!res.ok) {
                throw new Error(`HTTP error! status: ${res.status}`);
            }
            return res.json();
        })
        .then(data => {
            if (Array.isArray(data) && data.length > 0) {
                eventsDisplay.innerHTML = '<pre class="json-display">' +
                    JSON.stringify(data, null, 2) + '</pre>';
            } else if (typeof data === 'object') {
                eventsDisplay.innerHTML = '<pre class="json-display">' +
                    JSON.stringify(data, null, 2) + '</pre>';
            } else {
                eventsDisplay.innerHTML = '<div class="empty-state">No events found</div>';
            }
        })
        .catch(error => {
            eventsDisplay.innerHTML = '<div class="error-state">Error: ' +
                error.message + '</div>';
            console.error('Error loading events:', error);
        });
}

function book() {
    const eventId = document.getElementById('eventId').value;
    const userId = document.getElementById('userId').value;
    const seats = document.getElementById('seats').value;
    const resultDisplay = document.getElementById('result');

    if (!eventId || !userId || !seats) {
        resultDisplay.textContent = 'Please fill in all fields';
        resultDisplay.className = 'result-display error';
        return;
    }

    resultDisplay.textContent = 'Processing booking...';
    resultDisplay.className = 'result-display';

    fetch('/bookings', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            eventId: eventId,
            userId: userId,
            seats: seats
        })
    })
    .then(res => {
        if (!res.ok) {
            throw new Error(`HTTP error! status: ${res.status}`);
        }
        return res.text();
    })
    .then(data => {
        resultDisplay.textContent = data;
        resultDisplay.className = 'result-display success';

        // Clear form on success
        if (data.toLowerCase().includes('success') || data.toLowerCase().includes('booked')) {
            document.getElementById('eventId').value = '';
            document.getElementById('userId').value = '';
            document.getElementById('seats').value = '';
        }
    })
    .catch(error => {
        resultDisplay.textContent = 'Error: ' + error.message;
        resultDisplay.className = 'result-display error';
        console.error('Error booking ticket:', error);
    });
}
