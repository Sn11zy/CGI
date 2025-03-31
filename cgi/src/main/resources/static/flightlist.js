async function getList() {
  let dl = []
  const url = "http://localhost:8080/api";
  try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }

      await response.json().then((data) => {
      data.forEach((item) => {
      dl.push(item)})
      });
      console.log(dl);

    } catch (error) {
      console.error(error.message);
    }
  const target = document.getElementById("flights")
  dl.forEach((flight) =>{
    var newDiv = document.createElement("div");
    var content = document.createElement("p");
    content.appendChild(document.createTextNode(flight.origin + " " + flight.destination +" "+ flight.departure+ " " + flight.seats));
    newDiv.appendChild(content);
    target.appendChild(newDiv);
  })
  }
async function getData() {
  let dl = []
  var orig = document.getElementById("origin").value;
  var dest = document.getElementById("dest").value;
  const url = "http://localhost:8080/api?";
  try {
      const response = await fetch(url + new URLSearchParams({
        origin: orig,
        destination: dest,
      }).toString()
      );
      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }

      await response.json().then((data) => {
      data.forEach((item) => {
      dl.push(item)})
      });
      console.log(dl)


    } catch (error) {
      console.error(error.message);
    }
    const target = document.getElementById("flights");
    target.innerHTML = "";
    dl.forEach((flight) =>{
        var newDiv = document.createElement("div");
        var content = document.createElement("p");
        content.appendChild(document.createTextNode(flight.origin + " " + flight.destination +" "+ flight.departure+ " " + flight.seats));
        newDiv.appendChild(content);
        target.appendChild(newDiv);
      })
  }
