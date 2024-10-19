const resultsDiv = document.getElementById('results');
const mapDiv = document.getElementById('map');
const API_KEY = "a9a3ca38755cd21ad75e651671fcd0f9";
const btnRastrear = document.getElementById('trackButton');
const btnMostrarTodos = document.getElementById('showAllFlightsButton'); // Novo botão
let map;

async function fetchFlightData(flight) {
    const url = `https://api.aviationstack.com/v1/flights?access_key=${API_KEY}&flight_iata=${flight}`;
    const options = {
        method: "GET",
    };

    try {
        const response = await fetch(url, options);
        if (!response.ok) {
            throw new Error(`Erro na requisição: ${response.status}`);
        }
        const result = await response.json();
        return result;
    } catch (error) {
        console.error(error);
        throw new Error("Erro ao buscar os dados da API");
    }
}

// Lançar voos e segregar
async function fetchAllFlights() {
    const url = `https://api.aviationstack.com/v1/flights?access_key=${API_KEY}`; // Sem filtro
    const options = {
        method: "GET",
    };

    try {
        const response = await fetch(url, options);
        if (!response.ok) {
            throw new Error(`Erro na requisição: ${response.status}`);
        }
        const result = await response.json();
        return result;
    } catch (error) {
        console.error(error);
        throw new Error("Erro ao buscar os dados da API");
    }
}

function displayResults(data) {
    const statusFilter = document.getElementById('statusFilter').value;
    resultsDiv.innerHTML = '';
    mapDiv.style.display = 'none';

    if (data.data && Array.isArray(data.data) && data.data.length > 0) {
        data.data.forEach(flight => {
            const flightStatus = flight.flight_status || 'N/A';
            const latitude = flight.live?.latitude;
            const longitude = flight.live?.longitude;

            if (!statusFilter || flightStatus === statusFilter) {
                const flightInfo = document.createElement('div');
                flightInfo.classList.add('flight-info');

                const flightIata = flight.flight?.iata || 'N/A';
                const departureAirport = flight.departure?.airport || 'N/A';
                const departureIata = flight.departure?.iata || 'N/A';
                const departureScheduled = flight.departure?.scheduled || 'N/A';
                const airlineName = flight.airline?.name || 'N/A';
                const arrivalAirport = flight.arrival?.airport || 'N/A';
                const arrivalIata = flight.arrival?.iata || 'N/A';
                const arrivalScheduled = flight.arrival?.scheduled || 'N/A';

                flightInfo.innerHTML = `
                    <div>
                        <h3>${flightIata}</h3>
                        <p><strong>Origem:</strong> ${departureAirport} (${departureIata})</p>
                        <p><strong>Saída Programada:</strong> ${departureScheduled}</p>
                    </div>
                    <div>
                        <h3>${airlineName}</h3>
                        <p><strong>Destino:</strong> ${arrivalAirport} (${arrivalIata})</p>
                        <p><strong>Chegada Programada:</strong> ${arrivalScheduled}</p>
                    </div>
                    <div class="flight-status">
                        <p>Status: ${flightStatus}</p>
                    </div>
                    ${latitude && longitude ? `<button onclick="showMap(${latitude}, ${longitude})">Mostrar no Mapa</button>` : '<p>Localização não disponível</p>'}
                `;
                resultsDiv.appendChild(flightInfo);
            }
        });
    } else {
        resultsDiv.innerHTML = '<p>Nenhum voo encontrado.</p>';
    }
}

function showMap(latitude, longitude) {
    mapDiv.style.display = 'block';
    if (!map) {
        map = L.map('map').setView([latitude, longitude], 13);
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
        }).addTo(map);
    } else {
        map.setView([latitude, longitude], 13);
    }
    L.marker([latitude, longitude]).addTo(map);
}

btnRastrear.onclick = async (e) => {
    e.preventDefault();

    const flightInput = document.getElementById('flightInput').value.trim();
    if (flightInput) {
        try {
            const data = await fetchFlightData(flightInput);
            displayResults(data);
        } catch (error) {
            resultsDiv.innerHTML = `<p>Erro: ${error.message}</p>`;
        }
    } else {
        resultsDiv.innerHTML = '<p>Por favor, insira um código de voo.</p>';
    }
};

// Lançar todos os voos
btnMostrarTodos.onclick = async (e) => {
    e.preventDefault();
    try {
        const data = await fetchAllFlights();
        displayResults(data);
    } catch (error) {
        resultsDiv.innerHTML = `<p>Erro: ${error.message}</p>`;
    }
};
