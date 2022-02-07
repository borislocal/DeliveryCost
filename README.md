# Delivery Cost calculator
## Processes delivery parameters and calculate final cost
## Decision table converted into pairwise combinations for better test coverage

As a delivery cost calculator, function takes an input of the following parameters:
- shipment dimensions (big or small)
- delivery distance in kilometers
- delivery service workload coefficient (default, increased, high, very high)
- fragility attribute (is fragile or not)

### Dimensions
- small delivery size will add 100 to final cost
- big delivery size will add 200 to final cost

### Distance
Distance affects cost by the following ranges:
- up to 2 km inclusive will add 50 units
- above 2 km and up to 10 km inclusive will add 100 units
- above 10 km and up to 30 km inclusive will add 200 units
- above 30 km will add 300 units

### Fragility
Fragile delivery could be sent to 30km maximum and adds 300 units to total cost

### Workload coefficient
Workload coefficient is multiplied with final cost to balance service workload:
default = 1
increased = 1.2
high = 1.4
very high = 1.6

Also minimum delivery cost introduced to reflect and cover service expenses and is rounded up to 400 units.


testcases:
https://docs.google.com/spreadsheets/d/1nSPJ67zY1d5ioUGz-_UZGX8W-NIilIXZqThRaoaWpuM/edit?usp=sharing
