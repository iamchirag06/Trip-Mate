document.getElementById("showTrips").addEventListener("click", function () {
    document.getElementById("popup").classList.remove("hidden");
});

document.getElementById("closePopup").addEventListener("click", function () {
    document.getElementById("popup").classList.add("hidden");
});
document.querySelectorAll('button').forEach(button => {
    button.addEventListener('click', function () {
        let tripResults = document.getElementById('tripResults');
        tripResults.innerHTML = `
                    <div class="bg-white shadow-lg rounded-lg p-4 transform transition hover:scale-105">
                        <img src="https://source.unsplash.com/300x200/?travel" class="rounded-lg w-full mb-3">
                        <h3 class="text-lg font-semibold">Recommended Destination</h3>
                        <p class="text-gray-600">Based on your preferences</p>
                        <p class="text-teal-600 font-semibold mt-2">$699.00</p>
                    </div>
                `;

        gsap.from("#tripResults div", { opacity: 0, y: 50, duration: 1, ease: "power2.out" });
    });
});



// Sample data for each button
const tripData = {
    puiwing: {
        tripPlanning: [
            { name: "Economy Trip", price: "$15" },
            { name: "Comfortable", price: "$45" },
            { name: "Destination", price: "$120" },
        ],
        tripsing: {
            nese: 5,
            places: 32,
            services: 12,
            ailmenticTour: "Visit the Tropical Islands",
            saves: "$150",
            discount: "$50"
        }
    },
    flantnis: {
        tripPlanning: [
            { name: "Economy Trip", price: "$19" },
            { name: "Comfortable", price: "$55" },
            { name: "Destination", price: "$180" },
        ],
        tripsing: {
            nese: 8,
            places: 50,
            services: 20,
            ailmenticTour: "Discover the Mountain Adventures",
            saves: "$200",
            discount: "$75"
        }
    },
    chive: {
        tripPlanning: [
            { name: "Economy Trip", price: "$21" },
            { name: "Comfortable", price: "$61" },
            { name: "Destination", price: "$231" },
        ],
        tripsing: {
            nese: 13,
            places: 68,
            services: 10,
            ailmenticTour: "Explore the City Lights",
            saves: "$240",
            discount: "$100"
        }
    }
};

// Function to update the content
function updateContent(selectedTrip) {
    const trip = tripData[selectedTrip];

    // Update the Personalized Trip Planning section
    const planningSection = document.getElementById('personalized-trip-planning');
    planningSection.querySelectorAll('li').forEach((item, index) => {
        item.querySelector('span:first-child').textContent = trip.tripPlanning[index].name;
        item.querySelector('span:last-child').textContent = trip.tripPlanning[index].price;
    });

    // Update the Tripsing section
    const tripsingSection = document.getElementById('tripsing');
    tripsingSection.querySelector('.w-12 h-12:nth-child(1)').textContent = trip.tripsing.nese;
    tripsingSection.querySelector('.w-12 h-12:nth-child(2)').textContent = trip.tripsing.places;
    tripsingSection.querySelector('.w-12 h-12:nth-child(3)').textContent = trip.tripsing.services;
    tripsingSection.querySelector('.bg-blue-500 p').textContent = trip.tripsing.ailmenticTour;
    tripsingSection.querySelector('.text-center:nth-child(1) p:last-child').textContent = trip.tripsing.saves;
    tripsingSection.querySelector('.text-center:nth-child(2) p:last-child').textContent = trip.tripsing.discount;
}

// Event listeners for the buttons
document.getElementById('puiwing-btn').addEventListener('click', () => updateContent('puiwing'));
document.getElementById('flantnis-btn').addEventListener('click', () => updateContent('flantnis'));
document.getElementById('chive-btn').addEventListener('click', () => updateContent('chive'));

// Default content on load
updateContent('chive');
