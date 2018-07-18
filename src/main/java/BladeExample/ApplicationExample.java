package BladeExample;

import com.blade.Blade;

public class ApplicationExample {

	/*
	public static void main(String[] args) {
		Blade blade = Blade.me();

		blade.get("/", new RouteHandler() {
			@Override
			public void handle(Request request, Response response) {
				response.html("hello world.");
			}
		});

		// TODO: 怎么api老是变动啊，好好的用不行么？
		blade.start(ApplicationExample.class);
	}
	*/

	public static void main(String[] args) {
		Blade.me().get("/", (req, res) -> {
			res.text("Hello Blade");
		}).start(null);
	}
}