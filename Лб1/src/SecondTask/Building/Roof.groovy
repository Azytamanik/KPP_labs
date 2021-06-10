package SecondTask.Building

class Roof implements IPart{
    @Override
    def build() {
        return new Roof()
    }
}
