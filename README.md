# My Personal Project


### What will the application do?

Shortly, the application will allow a user to build a sandwich in addition to displaying the pricing of each topping added to the sandwich. The application may first prompt the user to choose either to start a new order or to view previous ones. The user having chosen that, they then get to pick what type of bread they want, type of protein, size of the sandwich,type of cheese and whether it should be toasted or not. After that, the user can pick the various greens they want added to their sandwich. Finally, the user is prompted to pick sauces that they can add to their sandwich. If a meal is picked, the user can pick the soda/water and the dessert they want. Finally, the user can head to checkout where a price with a breakdown can be viewed. 

### Who will use it?

Someone who wants to order a sandwich/meal, provided that there is a store that this application is linked to. Local sandwich shops needing to expand and advertise themselves can use this application which would allow more people to get to know the shop.  

### Why is this project of interest to you?

Food-ordering applications like Uber Eats and DoorDash are so dominant and successful nationwide. I believe creating an application similar to these are a great first step to my future in Computer Science. 

### User Stories
- As a user, I want to be able to add multiple sandwich components to an order
- As a user, I want to be able to save and load my previous orders

## Instructions for Grader
- You can generate the first required event related to adding Xs to a Y by choosing a bread (displayed as a radio button)
- You can generate the second required event related to adding Xs to a Y by choosing a protein (displayed as a radio button)
- You can locate my visual component on all the sandwich component pages (pictures)
- You can save the state of my application by going all the way to the drinks section, where you'll be prompted to order
- You can reload the state of my application by hitting view previous orders at the welcome page


#### Citations:
whitebread.jpeg - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.thefreshloaf.com%2Fnode%2F65459%2Foverpowered-subway-bread-recipe-open-source-original&psig=AOvVaw13eSBz-E8pxMSu6E47Ew_t&ust=1668914832013000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKCGz6-mufsCFQAAAAAdAAAAABAE

protein.jpeg - https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fprotein&psig=AOvVaw2PRyoxKR7Rr3VrVGI5PkWT&ust=1668914872067000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCJD8qMKmufsCFQAAAAAdAAAAABAE

cheese.jpeg - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.wallpaperflare.com%2Fpizza-slice-cheddar-cheese-wallpaper-97462&psig=AOvVaw1SChWUOV-xYq916PXm17cD&ust=1668914914896000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLCUltemufsCFQAAAAAdAAAAABAE

vegetables.jpeg - https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fvegetables&psig=AOvVaw3oOtTp9JaxYrpKynA9ae1-&ust=1668914948077000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCJikjeemufsCFQAAAAAdAAAAABAE

sauces.jpeg - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockphoto.com%2Fphotos%2Fsauce&psig=AOvVaw1DSKpLenHI8sa9o1TwKD37&ust=1668914973912000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCPi4q_OmufsCFQAAAAAdAAAAABAE

questionMark.png - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.kindpng.com%2Fimgv%2FToiTJi_green-question-mark-clip-art-at-clker-green%2F&psig=AOvVaw3KqthwgMhUxp1YT-PrCLdz&ust=1668914999312000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCOjpsP-mufsCFQAAAAAdAAAAABAE

dessert.jpeg - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwallpaperaccess.com%2Fdessert&psig=AOvVaw3CQx97AZ_rG5JwiphUe6AC&ust=1668915023907000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCMi4kounufsCFQAAAAAdAAAAABAE

drink.jpeg - https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Falcohol&psig=AOvVaw0LULIz2fotUbHb3YW2LZ3E&ust=1668915055998000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKDzt5qnufsCFQAAAAAdAAAAABAE

### Phase 4: Task 2
Mon Nov 28 20:26:35 PST 2022
Added Gluten-Free Bread to the sandwich order

Mon Nov 28 20:26:35 PST 2022
Added Bacon Strips to the sandwich order

Mon Nov 28 20:26:35 PST 2022
Added Cheddar Cheese to the sandwich order

Mon Nov 28 20:26:35 PST 2022
Added Onion to the sandwich order

Mon Nov 28 20:26:35 PST 2022
Added Caesar to the sandwich order

Mon Nov 28 20:26:35 PST 2022
Added Caesar to the sandwich order

Mon Nov 28 20:26:35 PST 2022
Bread size is chosen to be 12 inches

Mon Nov 28 20:26:35 PST 2022
Added Choco-Chip Cookie to the sandwich order

Mon Nov 28 20:26:35 PST 2022
Added Coca-Cola to the sandwich order

### Phase 4: Task 3
The main change I would make if I had more time was to make SandwichComponent an interface. This is because SandwichComponent is never used as an object in this project, it is simply a design to add all components (though different) to my sandwich. In addition, there is a lot of repeatable code in my UI and GUI classes, if I had more time, I would create abstract helper methods which would save a lot of time as well as make it easier to debug if there is an error.

